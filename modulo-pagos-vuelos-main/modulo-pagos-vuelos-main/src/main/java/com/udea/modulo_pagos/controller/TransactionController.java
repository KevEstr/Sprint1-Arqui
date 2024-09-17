package com.udea.modulo_pagos.controller;

import com.udea.modulo_pagos.entities.Transaction;
import com.udea.modulo_pagos.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @MutationMapping
    public Transaction createTransaction(@Argument Long bookingId, @Argument Long paymentMethodId,
                                         @Argument int totalPrice, @Argument Float additionalCharge) {
        return transactionService.createTransaction(bookingId, paymentMethodId, totalPrice, additionalCharge);
    }

    @QueryMapping
    public Transaction getTransactionById(@Argument Long id) {
        return transactionService.findById(id);
    }

    @MutationMapping
    public void updateTransactionStatus(@Argument Long id, @Argument String status) {
        transactionService.updateTransactionStatus(id, status);
    }
}
