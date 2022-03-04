package com.example.university.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "t_student")
public class Student extends Person {
    @Column(name = "isVerify")
    private Boolean isVerify = false;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = {@JoinColumn(name ="student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    @Column(name = "courses")
    private List<Course> courses;
}

