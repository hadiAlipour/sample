package com.example.university.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "t_teacher")
public class Teacher extends Person {

    private Boolean isVerify = false;

    @OneToMany
    @JoinColumn(name = "teacher_id")
    private Set<Course> courses;
}
