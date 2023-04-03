package com.ontop.walletservice.domain.service.payment;

import com.ontop.walletservice.domain.client.PaymentProviderClient;
import com.ontop.walletservice.domain.exception.InvalidBankAccountException;
import com.ontop.walletservice.domain.exception.InvalidPaymentException;
import com.ontop.walletservice.domain.exception.GeneralErrorWalletException;
import com.ontop.walletservice.domain.model.fee.TransactionFee;
import com.ontop.walletservice.domain.model.payment.PaymentProvider;
import com.ontop.walletservice.domain.model.payment.PaymentStatus;
import com.ontop.walletservice.domain.model.payment.PaymentState;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.domain.model.wallet.WalletTransaction;
import com.ontop.walletservice.domain.repository.PaymentRepository;
import com.ontop.walletservice.domain.repository.RecipientBankAccountRepository;
import com.ontop.walletservice.domain.service.fee.FeeService;
import com.ontop.walletservice.domain.service.wallet.WalletService;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public class DomainPaymentService implements PaymentService {


    private final RecipientBankAccountRepository recipientBankAccountRepository;


    private final PaymentRepository paymentRepository;

    private final WalletService walletService;

    private final PaymentProviderClient paymentProviderClient;

    private final FeeService feeService;


    @Override
    public Payment createPaymentTransaction(Long userId, Double amount) {

        checkValidPaymentUser(userId);
        checkValidPaymentAmount(amount);
        checkUserFounds(userId, amount);

        RecipientBankAccount userRecipientBankAccount = getUserBankAccount(userId);

        WalletTransaction walletTransaction = walletService.createWithdrawWalletTransaction(userId, amount);
        Payment payment = createPayment(userRecipientBankAccount, walletTransaction, amount);
        return payment;
    }

    @Override
    public List<Payment> getAllPayments(Long userId, Double amount, LocalDateTime createdFrom,
                                        LocalDateTime createdTo, int pageSize, int offSet) {
        return paymentRepository.getAllPayments(userId, amount, createdFrom, createdTo, pageSize, offSet);
    }

    @Override
    public void processAllPendingPayments() {
        List<Payment> payments  = paymentRepository.getAllPendingPayments();
        payments.forEach(payment -> {
            PaymentStatus paymentStatus = paymentProviderClient.getPaymentStatus(payment.getTransactionId());
            switch (paymentStatus) {
                case COMPLETED -> processCompletePayment(payment);
                case FAILED -> processFailPayment(payment);
            }
        });
    }


    private void processCompletePayment(Payment payment) {
       PaymentState paymentState = PaymentState.builder()
                .paymentId(payment.getId())
                .created(LocalDateTime.now())
                .status(PaymentStatus.COMPLETED)
                .build();

        paymentRepository.savePaymentState(paymentState);
    }

    private void processFailPayment(Payment payment) {

        walletService.createTopUpWalletTransaction(payment.getUserId(), payment.getAmount() + payment.getFee());
        PaymentState paymentState = PaymentState.builder()
                .paymentId(payment.getId())
                .created(LocalDateTime.now())
                .status(PaymentStatus.REFOUNDED)
                .build();
        paymentRepository.savePaymentState(paymentState);
    }

    private Payment createPayment(RecipientBankAccount userRecipientBankAccount, WalletTransaction walletTransaction, Double amount) {
        try {

            PaymentProvider paymentProvider = paymentProviderClient.createPaymentProvider(walletTransaction.getWalletBankAccount(),
                    userRecipientBankAccount, amount);

            Payment payment = buildPayment(userRecipientBankAccount, walletTransaction, amount);
            payment.setTransactionId(paymentProvider.getId());

            Payment createdPayment = paymentRepository.save(payment,
                    PaymentState.builder()
                    .status(PaymentStatus.PROCESSING)
                    .build()
            );

            return createdPayment;
        } catch (Exception e) {
            revertWithdrawTransaction(userRecipientBankAccount, walletTransaction, amount);
            throw new GeneralErrorWalletException("Unexpected error, it was not possible to process your payment");
        }

    }

    private void revertWithdrawTransaction(RecipientBankAccount userRecipientBankAccount,
                                           WalletTransaction walletTransaction, Double amount) {
        walletService.createTopUpWalletTransaction(walletTransaction.getUserId(), amount);
        Payment errorPayment = buildPayment(userRecipientBankAccount, walletTransaction, amount);
        paymentRepository.save(errorPayment, PaymentState.builder()
                .status(PaymentStatus.FAILED)
                .build());
    }

    private Payment buildPayment(RecipientBankAccount userRecipientBankAccount, WalletTransaction walletTransaction,
                                 Double amount) {
        TransactionFee fee = feeService.calculateFee(amount);
        return Payment.builder()
                .userId(walletTransaction.getUserId())
                .amount(fee.getFinalAmount())
                .bankAccount(userRecipientBankAccount)
                .walletTransaction(walletTransaction)
                .fee(fee.getTransactionFee())
                .build();
    }

    private void checkUserFounds(Long userId, Double amount) {
        Double userBalance = walletService.getWalletBalance(userId);
        if(userBalance < amount)
            throw new InvalidPaymentException("insufficient funds");
    }

    private static void checkValidPaymentAmount(Double amount) {
        if(amount <= 0)
            throw new InvalidPaymentException("To process a payment the amount for this transaction has to be upper then 0");
    }

    private static void checkValidPaymentUser(Long userId) {
        if(userId <= 0)
            throw new InvalidPaymentException("To process a payment, it's necessary to provide a user id");
    }

    private RecipientBankAccount getUserBankAccount(Long userId) {
        return recipientBankAccountRepository.findByUserId(userId)
                .orElseThrow(() -> new InvalidBankAccountException(
                        String.format("To process a payment the user with id: %s has to have a registered bank account",
                                userId))
                );
    }
}
