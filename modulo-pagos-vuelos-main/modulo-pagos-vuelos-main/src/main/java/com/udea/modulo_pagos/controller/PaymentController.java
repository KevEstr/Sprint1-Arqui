package com.udea.modulo_pagos.controller;

import com.udea.modulo_pagos.entities.Payment;
import com.udea.modulo_pagos.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    @MutationMapping
    public Payment createPayment(@Argument Payment payment) {
        return paymentService.createPayment(payment);
    }

    @MutationMapping
    public Payment processPayment(@Argument Long transactionId, @Argument int totalPaid, @Argument Integer gatewayPaymentId) {
        return paymentService.processPayment(transactionId, totalPaid, gatewayPaymentId);
    }

    @QueryMapping
    public Payment getPaymentById(@Argument Long id) {
        return paymentService.findPaymentById(id);
    }
}
