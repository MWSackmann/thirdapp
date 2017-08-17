package com.example.thirdapp.bootstrap;

import com.example.thirdapp.model.Address;
import com.example.thirdapp.model.Person;
import com.example.thirdapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by sackmann on 07.08.2017.
 */
@Component
public class PersonLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        for (int i = 0; i < 1; i++) {
            personRepository.save(new Person("Michael", "Huber " + i,
                                              new Address("Koeln", "Hauptstrasse", "1"),
                                              new Address("Berlin","Bahnhofsstrasse","99")));
        }
    }
}
