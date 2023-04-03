package com.ontop.walletservice.application.controller;

import com.ontop.walletservice.application.dto.fee.FeeResponse;
import com.ontop.walletservice.application.mapper.FeeMapper;
import com.ontop.walletservice.domain.service.fee.FeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/fees")
public class FeeController {

    private final FeeService feeService;

    private final FeeMapper feeMapper = FeeMapper.INSTANCE;

    @GetMapping(path = "/cost")
    public FeeResponse getCostFee(@RequestParam(name = "amount") Double amount) {
        return feeMapper.toTransactionFeeResponse(feeService.calculateFee(amount));
    }

}
