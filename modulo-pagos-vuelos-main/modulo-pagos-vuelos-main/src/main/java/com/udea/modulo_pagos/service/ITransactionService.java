package com.udea.modulo_pagos.service;

import com.udea.modulo_pagos.entities.Payment;
import com.udea.modulo_pagos.entities.Transaction;

public interface ITransactionService {

    public Transaction createTransaction(Long bookingId, Long paymentMethodId, int totalPrice, Float additionalCharge);
    public void updateTransactionStatus(Long id, String status);
    public Transaction findById(Long id);
    public void addPaymentToTransaction(Long transactionId, Payment payment);


}
