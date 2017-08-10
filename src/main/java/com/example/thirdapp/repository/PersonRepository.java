package com.example.thirdapp.repository;

import com.example.thirdapp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sackmann on 07.08.2017.
 */
public interface PersonRepository extends CrudRepository<Person, Long>{
}
