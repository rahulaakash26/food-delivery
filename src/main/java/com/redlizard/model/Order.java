package com.redlizard.model;


import com.redlizard.utils.enums.OrderStatus;
import com.redlizard.utils.enums.PaymentMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_mode", length = 10)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 10)
    private OrderStatus orderStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    private OrderDetails orderDetails;
}
