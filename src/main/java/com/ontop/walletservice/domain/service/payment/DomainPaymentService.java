package com.ontop.walletservice.domain.service.payment;

import com.ontop.walletservice.domain.exception.bank.InvalidBankAccountException;
import com.ontop.walletservice.domain.exception.payment.InvalidPaymentException;
import com.ontop.walletservice.domain.model.bank.RecipientBankAccount;
import com.ontop.walletservice.domain.model.payment.Payment;
import com.ontop.walletservice.domain.repository.BankAccountRepository;
import com.ontop.walletservice.domain.service.wallet.WalletService;

public class DomainPaymentService implements PaymentService {


    private final BankAccountRepository bankAccountRepository;

    private final WalletService walletService;

    public DomainPaymentService(BankAccountRepository bankAccountRepository,
                                WalletService walletService) {
        this.bankAccountRepository = bankAccountRepository;
        this.walletService = walletService;
    }

    @Override
    public Payment createPaymentTransaction(Long userId, Double amount) {

        checkValidPaymentUser(userId);
        checkValidPaymentAmount(amount);
        checkUserFounds(userId, amount);

        RecipientBankAccount userRecipientBankAccount = getUserBankAccount(userId);

        walletService.createWalletTransaction(userId, -amount);

        //Tengo que crear en mi base de datos

        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAmount(amount);
        payment.setBankAccount(userRecipientBankAccount);

        // tenemos que restar al balance
        // Tenemos que crear una n





        // tenemos que invocar el metodo de pago si pasa algun error debemos devolver lo restado


        return null;
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
        return bankAccountRepository.findByUserId(userId)
                .orElseThrow(() -> new InvalidBankAccountException(
                        String.format("To process a payment the user with id: %s has to have a registered bank account",
                                userId))
                );
    }
}
