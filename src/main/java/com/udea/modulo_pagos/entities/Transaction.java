package com.udea.modulo_pagos.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @Column(name = "transaction_date")
    private LocalDate date;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "additional_charge")
    private Float additionalCharge;

    @ManyToOne
    @JoinColumn(name="id_booking", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name="id_payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "transaction")
    private List<Payment> payments;

    public Transaction() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Float additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
