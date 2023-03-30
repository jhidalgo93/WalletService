package com.ontop.walletservice.application.config;

import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.domain.repository.BankAccountRepository;
import com.ontop.walletservice.domain.repository.WalletBankAccountRepository;
import com.ontop.walletservice.domain.repository.WalletTransactionRepository;
import com.ontop.walletservice.domain.service.bank.RecipientBankAccountService;
import com.ontop.walletservice.domain.service.bank.DomianRecipientBankAccountService;
import com.ontop.walletservice.domain.service.payment.DomainPaymentService;
import com.ontop.walletservice.domain.service.payment.PaymentService;
import com.ontop.walletservice.domain.service.wallet.DomainWalletService;
import com.ontop.walletservice.domain.service.wallet.WalletService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RecipientBankAccountService bankAccountService(BankAccountRepository bankAccountRepository) {
        return new DomianRecipientBankAccountService(bankAccountRepository);
    }


    @Bean
    public PaymentService paymentService(BankAccountRepository bankAccountRepository,
                                                    WalletService walletService) {
        return new DomainPaymentService(bankAccountRepository, walletService);
    }


    @Bean
    public WalletService walletService(WalletClient walletClient,
                                       WalletTransactionRepository walletTransactionRepository,
                                       WalletBankAccountRepository walletBankAccountRepository) {
        return new DomainWalletService(walletClient, walletTransactionRepository, walletBankAccountRepository);
    }

}
