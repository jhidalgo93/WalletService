package com.ontop.walletservice.infrastructure.feign.model.payment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PaymentSourceInformationProvider implements Serializable {

    private String name;
}
