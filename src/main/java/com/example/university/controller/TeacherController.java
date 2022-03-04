package com.example.university.controller;

import com.example.university.model.Person;
import com.example.university.model.Teacher;
import com.example.university.model.TeacherLoginDto;
import com.example.university.service.PersonService;
import com.example.university.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    private final TeacherService teacherService;
    private final PersonService personService;

    public TeacherController(TeacherService teacherService, PersonService personService) {
        this.teacherService = teacherService;
        this.personService = personService;
    }

    @PostMapping(value = "teacher/register")
    public String register(@RequestBody Teacher teacher){
        Teacher saved = teacherService.register(teacher);
        if (null != saved)
            return "ثبت نام شما با موفقیت انجام گردید.";
        else
            return "خطا در انجام علیتات ثبت نام";
    }

    @PostMapping(value = "teacher/login")
    public ResponseEntity<?> login(@RequestBody TeacherLoginDto teacherLoginDto){
        Person person = personService.login(teacherLoginDto.getUserName() , teacherLoginDto.getPassword());
        if (null != person)
            return new ResponseEntity<>(person , HttpStatus.FOUND);
        else
            return new ResponseEntity<>("no user found with username : " + teacherLoginDto.getUserName(), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "teacher/notVerify")
    public List<Teacher> findAllNotVerifyTeacher (){
        return teacherService.findAllNotVerifyTeacher();
    }

    @PostMapping(value = "teacher/isVerify")
    public String isVerify(@RequestParam Long id){
        Boolean saved = teacherService.verifyTeacher(id);
        if (null != saved)
            return "تایید شد";
        else
            return "خطا در انجام علیتات";
    }
    @GetMapping(value = "teacher/teachers")
    public List<Teacher> findAllTeachers (){
        return (List<Teacher>) teacherService.findAllTeacher();
    }
}
