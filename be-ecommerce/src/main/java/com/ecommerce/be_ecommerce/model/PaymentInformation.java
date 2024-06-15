package com.ecommerce.be_ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name="payment_information")
public class PaymentInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cardholder_name")
    private String cardholderName;
    @Column(name="card_number")
    private String cardNumber;
    @Column(name="expiration_date")
    private String expirationDate;
    @Column(name="cvv")
    private String cvv;

    public PaymentInformation() {
    }

}
