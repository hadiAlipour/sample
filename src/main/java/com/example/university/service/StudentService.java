package com.example.university.service;

import com.example.university.model.Course;
import com.example.university.model.Student;
import com.example.university.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student register(Student student){
        return studentRepo.save(student);
    }

    public List<Student> findAllNotVerifyStudent(){
       return (List<Student>) studentRepo.findAllNotVerifyStudent();
    }

    public Boolean verifyStudent(long id){
        Student student = studentRepo.getById(id);
        student.setIsVerify(true);
        Student updatedStudent = register(student);
        return null != updatedStudent;
    }

    public List<Student> findAllStudent(){
        return (List<Student>) studentRepo.findAll();
    }


    public Student updateCourse(Long id , Course course ){
        Student student = studentRepo.findById(id).get();
        student.getCourses().add(course);
        return studentRepo.save(student);
    }
    
}
