package com.example.thirdapp.controller;

import com.example.thirdapp.model.AddressLink;
import com.example.thirdapp.model.Person;
import com.example.thirdapp.service.PersonService;
import com.example.tool.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by sackmann on 07.08.2017.
 */
@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    AddressService addressService;

    // method returns all persons available
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity get() {
        return ResponseEntity.ok(personService.readAll());
    }

    // method reads single person via its id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") long id) {
        final Person person = personService.read(id);
        if(person != null) {
            return new ResponseEntity(person, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    // method deletes single post via its id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") long id) {
        personService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    // Method creates person
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity post(@Valid @RequestBody Person person) {
        for (AddressLink addressLink : person.getAddressLinks()) {
            Long addressLinkId = addressService.create(addressLink.getAddress());
            addressLink.setId(addressLinkId);
            addressLink.setPerson(person);
        }
        personService.create(person);
        return new ResponseEntity(person.getId(), new HttpHeaders(), HttpStatus.CREATED);
    }

}
