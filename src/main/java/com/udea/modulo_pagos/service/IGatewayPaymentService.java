package com.udea.modulo_pagos.service;

import com.udea.modulo_pagos.entities.GatewayPayment;

import java.util.List;

public interface IGatewayPaymentService {

    List<GatewayPayment> allGatewayPaymentMethods();

}
