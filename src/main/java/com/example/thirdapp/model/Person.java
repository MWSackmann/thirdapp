package com.example.thirdapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sackmann on 07.08.2017.
 */
@Entity(name = "PERSON_TAB")
public class Person {
    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FNAME")
    private String firstName;

    @Column(name = "LNAME")
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "person")
    private List<AddressLink> addressLinks;

//    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "person")
//    private List<Address> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

//    public List<Address> getAddresses() {
//        return addresses;
//    }

//    public void setAddresses(List<Address> addresses) {
//        this.addresses = addresses;
//    }


    public List<AddressLink> getAddressLinks() {
        return addressLinks;
    }

    public void setAddressLinks(List<AddressLink> addressLinks) {
        this.addressLinks = addressLinks;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public Person(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.addresses = new ArrayList<>();
//        address.setPerson(this);
//        this.addresses.add(address);
//
//    }

    public Person() {
    }
}
