package com.example.thirdapp.controller;

import com.example.thirdapp.model.Person;
import com.example.thirdapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sackmann on 07.08.2017.
 */
@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity get() {
        return ResponseEntity.ok(personRepository.findAllByOrderByIdDesc());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(personRepository.findOne(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody Person person) {
        return ResponseEntity.ok(personRepository.save(person).getId());
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateById(@PathVariable("id") long id, @Valid @RequestBody Person person) {
        final Person personOld = personRepository.findOne(id);
        if (personOld == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        personRepository.save(person);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable("id") long id) {
        final Person person = personRepository.findOne(id);
        if (person == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        personRepository.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
