package com.example.thirdapp.model;

import javax.persistence.*;

/**
 * Created by sackmann on 14.08.2017.
 */
@Entity(name = "ADDR_LINK")
public class AddressLink {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDR_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="EMP_ID")
    private Person person;

    public AddressLink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
