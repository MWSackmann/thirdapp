package com.example.thirdapp.service;

import com.example.thirdapp.model.AddressLink;
import com.example.thirdapp.model.Person;
import com.example.thirdapp.repository.PersonRepository;
import com.example.tool.model.Address;
import com.example.tool.service.AddressService;
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

    @Autowired
    private AddressService addressService;

    public void create(Person person){

        for(AddressLink addressLink : person.getAddressLinks()){
            addressLink.setPerson(person);
            if(addressLink.getAddress()!= null ){
                addressLink.setId(addressService.create(addressLink.getAddress()));
            }
        }
        personRepository.save(person);

    }

    public Person read(Long id){

        Person person = personRepository.findOne(id);
        if(person== null){
            return null;
        }
        for(AddressLink addressLink: person.getAddressLinks()){
            addressLink.setAddress(addressService.read(addressLink.getId()));
        }
        return person;
    }

    public Iterable<Person> readAll(){
        return personRepository.findAll();
    }

    public void update(Person person){
        for(AddressLink addressLink: person.getAddressLinks()){
            if(addressLink.getAddress() == null){
                addressService.delete(addressLink.getId());
            } else {
                addressService.update(addressLink.getAddress());
            }
        }
        personRepository.save(person);
    }


    public void delete(Long id){
        Person person = personRepository.findOne(id);
        if(person != null){
            for(AddressLink addressLink: person.getAddressLinks()){
                addressService.delete(addressLink.getId());
            }
            personRepository.delete(id);
        }
    }
}
