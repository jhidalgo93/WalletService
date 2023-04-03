package com.ontop.walletservice.domain.service.fee;

import com.ontop.walletservice.domain.model.fee.TransactionFee;

public interface FeeService {

    TransactionFee calculateFee(Double amount);

}
