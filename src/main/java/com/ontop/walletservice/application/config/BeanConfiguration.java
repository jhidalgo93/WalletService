package com.ontop.walletservice.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontop.walletservice.domain.client.PaymentProviderClient;
import com.ontop.walletservice.domain.client.WalletClient;
import com.ontop.walletservice.domain.repository.PaymentRepository;
import com.ontop.walletservice.domain.repository.RecipientBankAccountRepository;
import com.ontop.walletservice.domain.repository.WalletBankAccountRepository;
import com.ontop.walletservice.domain.repository.WalletTransactionRepository;
import com.ontop.walletservice.domain.service.recipient.RecipientBankAccountService;
import com.ontop.walletservice.domain.service.recipient.DomianRecipientBankAccountService;
import com.ontop.walletservice.domain.service.payment.DomainPaymentService;
import com.ontop.walletservice.domain.service.payment.PaymentService;
import com.ontop.walletservice.domain.service.wallet.DomainWalletService;
import com.ontop.walletservice.domain.service.wallet.WalletService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public RecipientBankAccountService bankAccountService(RecipientBankAccountRepository recipientBankAccountRepository) {
        return new DomianRecipientBankAccountService(recipientBankAccountRepository);
    }


    @Bean
    public PaymentService paymentService(RecipientBankAccountRepository recipientBankAccountRepository,
                                         WalletService walletService, PaymentRepository paymentRepository,
                                         PaymentProviderClient paymentProviderClient) {
        return new DomainPaymentService(recipientBankAccountRepository, paymentRepository, walletService,
                paymentProviderClient);
    }


    @Bean
    public WalletService walletService(WalletClient walletClient,
                                       WalletTransactionRepository walletTransactionRepository,
                                       WalletBankAccountRepository walletBankAccountRepository) {
        return new DomainWalletService(walletClient, walletTransactionRepository, walletBankAccountRepository);
    }



}
