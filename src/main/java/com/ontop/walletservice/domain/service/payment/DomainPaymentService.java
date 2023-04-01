package com.ontop.walletservice.domain.service.payment;

import com.ontop.walletservice.domain.client.PaymentProviderClient;
import com.ontop.walletservice.domain.exception.InvalidBankAccountException;
import com.ontop.walletservice.domain.exception.InvalidPaymentException;
import com.ontop.walletservice.domain.exception.GeneralErrorWalletException;
import com.ontop.walletservice.domain.model.payment.PaymentProvider;
import com.ontop.walletservice.domain.model.payment.PaymentState;
import com.ontop.walletservice.domain.model.payment.PaymentStatus;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.domain.model.wallet.WalletTransaction;
import com.ontop.walletservice.domain.repository.PaymentRepository;
import com.ontop.walletservice.domain.repository.RecipientBankAccountRepository;
import com.ontop.walletservice.domain.service.wallet.WalletService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DomainPaymentService implements PaymentService {


    private final RecipientBankAccountRepository recipientBankAccountRepository;


    private final PaymentRepository paymentRepository;

    private final WalletService walletService;

    private final PaymentProviderClient paymentProviderClient;


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

    private Payment createPayment(RecipientBankAccount userRecipientBankAccount, WalletTransaction walletTransaction, Double amount) {
        try {

            PaymentProvider paymentProvider = paymentProviderClient.createPaymentProvider(walletTransaction.getWalletBankAccount(),
                    userRecipientBankAccount, amount);

            Payment payment = buildPayment(userRecipientBankAccount, walletTransaction, amount);
            payment.setTransactionId(paymentProvider.getId());

            Payment createdPayment = paymentRepository.save(payment,
                    PaymentState.builder()
                    .status(PaymentStatus.IN_PROGRESS)
                    .build()
            );

            return createdPayment;
        } catch (Exception e) {
            revertWithdrawTransaction(userRecipientBankAccount, walletTransaction, amount);
            throw new GeneralErrorWalletException("Unexpected error, it was not possible to process your payment");
        }

    }

    private void revertWithdrawTransaction(RecipientBankAccount userRecipientBankAccount, WalletTransaction walletTransaction, Double amount) {
        walletService.createTopUpWalletTransaction(walletTransaction.getUserId(),
                walletTransaction.getAmount());
        Payment errorPayment = buildPayment(userRecipientBankAccount, walletTransaction, amount);
        paymentRepository.save(errorPayment, PaymentState.builder()
                .status(PaymentStatus.ERROR)
                .build());
    }

    private Payment buildPayment(RecipientBankAccount userRecipientBankAccount, WalletTransaction walletTransaction, Double amount) {
        return Payment.builder()
                .userId(walletTransaction.getUserId())
                .amount(amount)
                .bankAccount(userRecipientBankAccount)
                .walletTransaction(walletTransaction)
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
