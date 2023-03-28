package com.ontop.walletservice.application.controller;

import com.ontop.walletservice.application.dto.BankTransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/user/{user_id}/bank-transactions")
public class BankTransactionController {

    @PostMapping
    public BankTransactionRequest createTransaction(@PathVariable long userId,
                                                    @RequestBody BankTransactionRequest bankTransactionRequest) {
        return null;
    }


    @GetMapping
    public List<BankTransactionRequest> getTransactions(@PathVariable long userId) {

        return null;
    }


    @GetMapping(path = "/cost")
    public List<BankTransactionRequest> getCostTransaction(@PathVariable long userId) {

        return null;
    }


}
