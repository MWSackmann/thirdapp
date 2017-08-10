package com.example.thirdapp.model;

import javax.persistence.*;

/**
 * Created by sackmann on 10.08.2017.
 */
@Entity(name = "MAIL")
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MAIL_ID")
    private Long id;

    @Column(name = "MAIL_ADDR")
    private String mailAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ADDR_ID")
    private Address address;

    public Mail() {
    }

    public Mail(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

