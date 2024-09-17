package com.udea.modulo_pagos.service.implementation;

import com.udea.modulo_pagos.entities.Payment;
import com.udea.modulo_pagos.entities.PaymentStatus;
import com.udea.modulo_pagos.entities.Transaction;
import com.udea.modulo_pagos.repositories.IPaymentRepository;
import com.udea.modulo_pagos.service.IPaymentService;
import com.udea.modulo_pagos.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private IPaymentRepository paymentRepository;

    @Autowired
    private ITransactionService transactionService;

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment processPayment(Long transactionId, int totalPaid, Integer gatewayPaymentId) {
        Transaction transaction = transactionService.findById(transactionId);

        // Verifica el estado de la transacción
        String transactionStatus = transaction.getStatus();
        if ("FAILED".equals(transactionStatus)) {
            throw new RuntimeException("Cannot process payment for a failed transaction.");
        }
        if ("SUCCESS".equals(transactionStatus)) {
            throw new RuntimeException("Transaction already paid successfully.");
        }

        Payment payment = new Payment();
        payment.setTransaction(transaction);
        payment.setTotalPaid(totalPaid);
        payment.setPaymentDate(LocalDate.now());
        payment.setGatewayPaymentId(gatewayPaymentId);

        // Suponiendo que se hace un procesamiento de pago con la pasarela
        // Aquí puedes simular el éxito o fracaso del pago
        boolean paymentSuccessful = simulatePaymentProcessing(); // este método debe simular el resultado del pago

        if (paymentSuccessful) {
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
            transactionService.updateTransactionStatus(transactionId, "SUCCESS");
        } else {
            payment.setPaymentStatus(PaymentStatus.FAILED);
            transactionService.updateTransactionStatus(transactionId, "FAILED");
        }

        return paymentRepository.save(payment);
    }

    private boolean simulatePaymentProcessing() {
        return Math.random() > 0.5;  // Simulación de éxito o fracaso
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }
}
