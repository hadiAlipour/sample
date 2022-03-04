package com.example.university.service;

import com.example.university.model.Teacher;
import com.example.university.repository.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepo teacherRepo;

    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Teacher register (Teacher teacher){
        return teacherRepo.save(teacher);
    }

    public List<Teacher> findAllNotVerifyTeacher(){
        return (List<Teacher>) teacherRepo.findAllNotVerifyTeacher();
    }

    public Boolean verifyTeacher(long id){
        Teacher teacher = teacherRepo.getById(id);
        teacher.setIsVerify(true);
        Teacher updatedTeacher = register(teacher);
        return null != updatedTeacher;
    }

    public List<Teacher> findAllTeacher(){
        return (List<Teacher>) teacherRepo.findAll();
    }
}
