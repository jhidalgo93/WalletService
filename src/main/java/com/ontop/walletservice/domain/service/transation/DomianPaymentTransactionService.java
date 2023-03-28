package com.ontop.walletservice.domain.service.transation;

import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.domain.exception.bank.InvalidBankAccountException;
import com.ontop.walletservice.domain.exception.payment.InvalidPaymentException;
import com.ontop.walletservice.domain.model.bank.RecipientBankAccount;
import com.ontop.walletservice.domain.model.transation.PaymentTransaction;
import com.ontop.walletservice.domain.repository.BankAccountRepository;

public class DomianPaymentTransactionService implements PaymentTransactionService {


    private final BankAccountRepository bankAccountRepository;

    private final WalletClient walletClient;

    public DomianPaymentTransactionService(BankAccountRepository bankAccountRepository, WalletClient walletClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.walletClient = walletClient;
    }

    @Override
    public PaymentTransaction createPaymentTransaction(Long userId, Double amount) {

        checkValidPaymentUser(userId);
        checkValidPaymentAmount(amount);
        checkUserFounds(userId, amount);

        RecipientBankAccount userRecipientBankAccount = getUserBankAccount(userId);
        PaymentTransaction paymentTransaction = new PaymentTransaction();
        paymentTransaction.setUserId(userId);
        paymentTransaction.setAmount(amount);
        paymentTransaction.setRecipientBankAccountId(userRecipientBankAccount.getId());

        //tenemos que restar al balance






        // tenemos que invocar el metodo de pago si pasa algun error debemos devolver lo restado


        return null;
    }

    private void checkUserFounds(Long userId, Double amount) {
        Double userBalance = walletClient.getUserBalance(userId);
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
