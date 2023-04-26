package com.example.Repository;
import com.example.Entity.Student;
//import com.example.SpringJpaDemoMaven1Application.Entity.Student;
//import com.example.springjpademomaven1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String str);
    List<Student> findByGuardianName(String guardianName);
    List<Student> findByLastNameNotNull();

    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String email);
}
