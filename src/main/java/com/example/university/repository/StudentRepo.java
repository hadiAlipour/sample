package com.example.university.repository;

import com.example.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.isVerify = FALSE ")
    List<Student> findAllNotVerifyStudent();
    @Query("select s from Student s where s.firstName like '%%'")
    List<Student> findByFirstName(String str);
}
