package com.udea.modulo_pagos.service.implementation;

import com.udea.modulo_pagos.entities.GatewayPayment;
import com.udea.modulo_pagos.entities.PaymentMethod;
import com.udea.modulo_pagos.repositories.IGatewayPaymentRepository;
import com.udea.modulo_pagos.repositories.IPaymentMethodRepository;
import com.udea.modulo_pagos.service.IGatewayPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GatewayPaymentServiceImpl implements IGatewayPaymentService {

    @Autowired
    private IGatewayPaymentRepository gatewayPaymentRepository;

    // Listar todas las pasarelas de pago disponibles.
    public List<GatewayPayment> allGatewayPaymentMethods() {
        Iterable<GatewayPayment> iterable = gatewayPaymentRepository.findAll();
        List<GatewayPayment> gatewayPayments = new ArrayList<>();

        for (GatewayPayment gatewayPayment : iterable) {
            gatewayPayments.add(gatewayPayment);
        }

        return gatewayPayments;
    }

}
