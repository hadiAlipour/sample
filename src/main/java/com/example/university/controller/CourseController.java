package com.example.university.controller;

import com.example.university.model.Course;
import com.example.university.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping(value = "/course/add")
    public String addCourse(@RequestBody Course course){
        Course saved = courseService.save(course);
        if (null != saved)
            return "ثبت دوره با موفقیت انجام گردید.";
        else
            return "خطا در انجام علیتات ثبت نام";
    }

    @GetMapping(value = "/courses")
    public List<Course> findAllCourses (){
        return (List<Course>) courseService.findAllCourses();
    }
}
