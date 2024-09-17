package com.udea.modulo_pagos.service;

import com.udea.modulo_pagos.entities.Payment;
import com.udea.modulo_pagos.entities.Transaction;

public interface IPaymentService {
    Payment createPayment(Payment payment);
    Payment processPayment(Long transactionId, int totalPaid, Integer gatewayPaymentId);
    Payment findPaymentById(Long id);
}
