package com.example.university.controller;

import com.example.university.model.Course;
import com.example.university.model.Person;
import com.example.university.model.Student;
import com.example.university.model.StudentLoginDto;
import com.example.university.service.PersonService;
import com.example.university.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;
    private final PersonService personService;

    public StudentController(StudentService studentService, PersonService personService) {
        this.studentService = studentService;
        this.personService = personService;
    }


    @PostMapping(value = "student/register")
    public String register(@RequestBody Student student) {
        Student saved = studentService.register(student);
        if (null != saved)
            return "ثبت نام شما با موفقیت انجام گردید.";
        else
            return "خطا در انجام علیتات ثبت نام";
    }

    @PostMapping(value = "student/login")
    public ResponseEntity<?> login(@RequestBody StudentLoginDto studentLoginDto){
        Person person = personService.login(studentLoginDto.getUserName() , studentLoginDto.getPassword());
        if (null != person)
            return new ResponseEntity<>(person , HttpStatus.FOUND);
        else
            return new ResponseEntity<>("no user found with username : " + studentLoginDto.getUserName(), HttpStatus.NO_CONTENT);
    }

    @GetMapping (value = "student/notVerify")
    public List<Student> findAllNotVerifyStudent (){
     return studentService.findAllNotVerifyStudent();
    }

    @PostMapping (value = "student/isVerify")
    public String isVerify(@RequestParam Long id){
        Boolean saved = studentService.verifyStudent(id);
        if (null != saved)
            return "تایید شد";
        else
            return "خطا در انجام علیتات";
    }

    @GetMapping(value = "student/students")
    public List<Student> findAllStudent (){
        return (List<Student>) studentService.findAllStudent();
    }


    @PostMapping (value = "student/course/add")
    public Student update(@RequestParam Long id , @RequestBody Course course){
        return studentService.updateCourse(id, course);
    }
}
