package com.example.university.repository;

import com.example.university.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    @Query("select t from Teacher t where t.isVerify = FALSE ")
    List<Teacher> findAllNotVerifyTeacher();
}
