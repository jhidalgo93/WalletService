package com.ontop.walletservice.application.dto.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequest  {

    @NotNull(message = "Routing number cannot be null")
    @JsonProperty("routing_number")
    private Long routingNumber;
    @NotNull(message = "Account number cannot be null")
    @JsonProperty("account_number")
    private Long accountNumber;

    @NotEmpty(message = "Bank name cannot be empty")
    @JsonProperty("bank_name")
    private String bankName;

    @NotEmpty(message = "Holder first name cannot be empty")
    @JsonProperty("holder_first_name")
    private String holderFirstName;

    @NotEmpty(message = "Holder last name cannot be empty")
    @JsonProperty("holder_last_name")
    private String holderLastName;

    @NotNull(message = "Holder national identification number cannot be null")
    @JsonProperty("holder_national_identification_number")
    private Long holderNationalIdentificationNumber;

}
