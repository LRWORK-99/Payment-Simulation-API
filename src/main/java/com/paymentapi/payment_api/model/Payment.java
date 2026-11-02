package com.paymentapi.payment_api.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private long amountCents;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private PaymentStatus paymentStatus;

    @Column(nullable=false)
    private Instant createdAt;

    protected Payment() {}

    public Payment(Long amountCents) {
        this.amountCents = amountCents;
        this.paymentStatus = PaymentStatus.PENDING;
        this.createdAt = Instant.now();
    }

}
