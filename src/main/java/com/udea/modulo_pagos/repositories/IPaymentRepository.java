package com.udea.modulo_pagos.repositories;

import com.udea.modulo_pagos.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IPaymentRepository extends CrudRepository<Payment, Long> {
    List<Payment> findByTransactionId(Long transactionId);
}
