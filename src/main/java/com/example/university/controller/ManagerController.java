package com.example.university.controller;

import com.example.university.model.Manager;
import com.example.university.model.ManagerLoginDto;
import com.example.university.model.Person;
import com.example.university.service.ManagerService;
import com.example.university.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {
    private final ManagerService managerService;
    private final PersonService personService;

    public ManagerController(ManagerService managerService, PersonService personService) {
        this.managerService = managerService;
        this.personService = personService;
    }
    @PostMapping(value = "manager/register")
    public String register(@RequestBody Manager manager){
        Manager saved = managerService.register(manager);
        if (null != saved)
            return "ثبت نام شما با موفقیت انجام گردید.";
        else
            return "خطا در انجام علیتات ثبت نام";
    }

    @PostMapping(value = "manager/login")
    public ResponseEntity<?> login(@RequestBody ManagerLoginDto managerLoginDto){
        Person person = personService.login(managerLoginDto.getUserName() , managerLoginDto.getPassword());
        if (null != person)
            return new ResponseEntity<>(person , HttpStatus.FOUND);
        else
            return new ResponseEntity<>("no user found with username : " + managerLoginDto.getUserName(), HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "manager/managers")
    public List<Manager> findAllManagers (){
        return (List<Manager>) managerService.findAllManger();
    }
}
