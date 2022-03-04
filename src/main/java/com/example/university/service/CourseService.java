package com.example.university.service;

import com.example.university.model.Course;
import com.example.university.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course save(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> findAllCourses(){
        return (List<Course>) courseRepo.findAll();
    }
}
