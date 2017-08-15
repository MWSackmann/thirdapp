package com.example.thirdapp.bootstrap;

import com.example.thirdapp.model.AddressLink;
import com.example.thirdapp.model.Person;
import com.example.thirdapp.service.PersonService;
import com.example.tool.model.Address;
import com.example.tool.model.Mail;
import com.example.tool.model.Phone;
import com.example.tool.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by sackmann on 07.08.2017.
 */
@Component
public class PersonLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    PersonService personService;

    @Autowired
    AddressService addressService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Person person = new Person();
        person.setFirstName("Michael");
        person.setLastName("Mueller");
        person.setAddressLinks(new ArrayList<>());

        Address address = new Address();
        address.getCommunication().setPhones(new ArrayList<>());
        address.getCommunication().setMails(new ArrayList<>());
        address.setCity("Koel");
        address.setStreet("Hauptstrasse");
        address.setHouseNo("1");

        Phone phone = new Phone();
        phone.setAddress(address);
        phone.setPhoneNumber("1234567");
        address.getCommunication().getPhones().add(phone);

        Mail mail = new Mail();
        mail.setAddress(address);
        mail.setMailAddress("michael@test.com");
        address.getCommunication().getMails().add(mail);
        Long addressId = addressService.create(address);

        AddressLink addressLink = new AddressLink();
        addressLink.setPerson(person);
        addressLink.setId(addressId);
        person.getAddressLinks().add(addressLink);
        personService.create(person);



    }
}
