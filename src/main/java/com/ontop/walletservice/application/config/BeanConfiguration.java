package com.ontop.walletservice.application.config;

import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.domain.repository.BankAccountRepository;
import com.ontop.walletservice.domain.service.bank.RecipientBankAccountService;
import com.ontop.walletservice.domain.service.bank.DomianRecipientBankAccountService;
import com.ontop.walletservice.domain.service.transation.DomianPaymentTransactionService;
import com.ontop.walletservice.domain.service.transation.PaymentTransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RecipientBankAccountService bankAccountService(BankAccountRepository bankAccountRepository) {
        return new DomianRecipientBankAccountService(bankAccountRepository);
    }


    @Bean
    public PaymentTransactionService paymentTransactionService(BankAccountRepository bankAccountRepository,
                                                               WalletClient walletClient) {
        return new DomianPaymentTransactionService(bankAccountRepository, walletClient);
    }


}
