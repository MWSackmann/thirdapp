package com.example.thirdapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sackmann on 07.08.2017.
 */
@Entity(name = "ADDR")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDR_ID")
    private Long id;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE_NO")
    private String houseNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="EMP_ID")
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

     public void setPerson(Person person) {
        this.person = person;
    }

    public Address(String city, String street, String houseNo) {
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
    }

    public Address() {
    }
}
