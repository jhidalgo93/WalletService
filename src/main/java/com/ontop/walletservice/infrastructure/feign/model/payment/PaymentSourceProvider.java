package com.ontop.walletservice.infrastructure.feign.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PaymentSourceProvider implements Serializable {

    private String type;

    private PaymentSourceInformationProvider sourceInformation;
    private PaymentAccountData data;

}
