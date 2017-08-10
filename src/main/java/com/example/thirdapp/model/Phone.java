package com.example.thirdapp.model;

import javax.persistence.*;

/**
 * Created by sackmann on 10.08.2017.
 */
@Entity(name = "PHONE")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PHONE_ID")
    private Long id;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ADDR_ID")
    private Address address;

    public Phone() {
    }

    public Phone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

