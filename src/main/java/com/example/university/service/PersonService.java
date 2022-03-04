package com.example.university.service;

import com.example.university.model.Person;
import com.example.university.repository.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person save(Person person){
        return personRepo.save(person);
    }

    public Person login(String username , String password){
        Person person = personRepo.findByUserName(username);
        if (null != person && person.getPassword().equals(password))
            return person ;
        return null;
    }



}
