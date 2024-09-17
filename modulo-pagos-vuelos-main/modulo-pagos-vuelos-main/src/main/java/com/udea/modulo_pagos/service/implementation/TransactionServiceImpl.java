package com.udea.modulo_pagos.service.implementation;

import com.udea.modulo_pagos.entities.Booking;
import com.udea.modulo_pagos.entities.Payment;
import com.udea.modulo_pagos.entities.PaymentMethod;
import com.udea.modulo_pagos.entities.Transaction;
import com.udea.modulo_pagos.repositories.IBookingRepository;
import com.udea.modulo_pagos.repositories.IPaymentMethodRepository;
import com.udea.modulo_pagos.repositories.ITransactionRepository;
import com.udea.modulo_pagos.service.IPaymentMethodService;
import com.udea.modulo_pagos.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private IBookingRepository bookingRepository;

    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;

    public Transaction createTransaction(Long bookingId, Long paymentMethodId, int totalPrice, Float additionalCharge) {
        // Busca las entidades Booking y PaymentMethod
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid booking ID"));

        PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentMethodId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment method ID"));

        // Crea la transacción con los datos
        Transaction transaction = new Transaction();
        transaction.setBooking(booking);
        transaction.setPaymentMethod(paymentMethod);
        transaction.setTotalPrice(totalPrice);
        transaction.setAdditionalCharge(additionalCharge);
        transaction.setStatus("PENDING"); // O el estado que desees
        transaction.setDate(LocalDate.now());

        // Guarda la transacción
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public void addPaymentToTransaction(Long transactionId, Payment payment) {

    }

    @Override
    public void updateTransactionStatus(Long id, String status) {
        Transaction transaction = findById(id);
        transaction.setStatus(status);
        transactionRepository.save(transaction);
    }
}
