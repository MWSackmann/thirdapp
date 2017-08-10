package com.example.thirdapp.bootstrap;

import com.example.thirdapp.model.Address;
import com.example.thirdapp.model.Mail;
import com.example.thirdapp.model.Person;
import com.example.thirdapp.model.Phone;
import com.example.thirdapp.repository.PersonRepository;
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
    PersonRepository personRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        Person person = new Person();
        person.setFirstName("Michael");
        person.setLastName("Mueller");
        person.setAddresses(new ArrayList<>());

        Address address = new Address();
        address.getCommunication().setPhones(new ArrayList<>());
        address.getCommunication().setMails(new ArrayList<>());
        address.setPerson(person);
        address.setCity("Koel");
        address.setStreet("Hauptstrasse");
        address.setHouseNo("1");
        person.getAddresses().add(address);

        Phone phone = new Phone();
        phone.setAddress(address);
        phone.setPhoneNumber("1234567");
        address.getCommunication().getPhones().add(phone);

        Mail mail = new Mail();
        mail.setAddress(address);
        mail.setMailAddress("michael@test.com");
        address.getCommunication().getMails().add(mail);

        personRepository.save(person);

//        for (int i = 0; i < 5; i++) {
//            personRepository.save(new Person("Michael", "Huber " + i,
//                                              new Address("Koeln", "Hauptstrasse", "1"),
//                                              new Address("Berlin","Bahnhofsstrasse","99")));
//        }
    }
}
