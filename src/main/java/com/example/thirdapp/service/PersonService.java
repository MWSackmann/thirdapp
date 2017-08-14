package com.example.thirdapp.service;

import com.example.thirdapp.model.AddressLink;
import com.example.thirdapp.model.Person;
import com.example.thirdapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sackmann on 14.08.2017.
 */

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void create(Person person){

        for(AddressLink addressLink : person.getAddressLinks()){
            addressLink.setPerson(person);
        }
        personRepository.save(person);

    }

    public Person read(Long id){
        return personRepository.findOne(id);
    }

    public Iterable<Person> readAll(){
        return personRepository.findAll();
    }

    public void delete(Long id){
        if(personRepository.findOne(id) != null){
            personRepository.delete(id);
        }
    }
}
