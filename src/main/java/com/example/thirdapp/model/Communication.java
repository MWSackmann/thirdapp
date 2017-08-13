package com.example.thirdapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by sackmann on 10.08.2017.
 */
@Embeddable
public class Communication {

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "address")
    private List<Phone> phones;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "address")
    private List<Mail> mails;

    public Communication() {
    }

    public Communication(List<Phone> phones, List<Mail> mails) {
        this.phones = phones;
        this.mails = mails;
    }

    public List<Mail> getMails() {
        return mails;
    }

    public void setMails(List<Mail> mails) {
        this.mails = mails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}

