package com.ontop.walletservice.infrastructure.client.payment.mapper;

import com.ontop.walletservice.domain.model.payment.PaymentProvider;
import com.ontop.walletservice.domain.model.recipient.RecipientBankAccount;
import com.ontop.walletservice.domain.model.wallet.WalletBankAccount;
import com.ontop.walletservice.infrastructure.client.payment.dto.request.PaymentDestinationProvider;
import com.ontop.walletservice.infrastructure.client.payment.dto.request.PaymentSourceProvider;
import com.ontop.walletservice.infrastructure.client.payment.dto.response.PaymentProviderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentProviderMapper {

    PaymentProviderMapper INSTACE = Mappers.getMapper(PaymentProviderMapper.class);

    @Mapping(target = "type", source = "type")
    @Mapping(target = "sourceInformation.name", source = "name")
    @Mapping(target = "account.accountNumber", source = "accountNumber")
    @Mapping(target = "account.currency", source = "currency")
    @Mapping(target = "account.routingNumber", source = "routingNumber")
    PaymentSourceProvider toPaymentSourceProvider(WalletBankAccount walletBankAccount);

    @Mapping(target = "name", source = "bankName")
    @Mapping(target = "account.accountNumber", source = "accountNumber")
    @Mapping(target = "account.currency", source = "currency")
    @Mapping(target = "account.routingNumber", source = "routingNumber")
    PaymentDestinationProvider toPaymentDestinationProvider(RecipientBankAccount recipientBankAccount);

    @Mapping(target = "id", source = "paymentInfo.id")
    @Mapping(target = "amount", source = "paymentInfo.amount")
    @Mapping(target = "status", source = "requestInfo.status")
    PaymentProvider toPaymentProvider(PaymentProviderResponse paymentProviderResponse);

}
