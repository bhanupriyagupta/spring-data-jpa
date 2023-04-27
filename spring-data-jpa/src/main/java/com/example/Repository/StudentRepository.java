package com.example.Repository;
import com.example.Entity.Student;
//import com.example.SpringJpaDemoMaven1Application.Entity.Student;
//import com.example.springjpademomaven1.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String str);
    List<Student> findByGuardianName(String guardianName);
    List<Student> findByLastNameNotNull();
    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameOfEmailId(String email);

    //Native Query(SQL)
    @Query(value = "select * from t_student s where s.email_id = ?1 ",
            nativeQuery = true)
    String getStudentByEmailAddressNative(String emailId);

    //Native Query with param(here we are replacing ?1 with :email_id
    @Query(value = "select * from t_student s where s.email_id = :email_id",
            nativeQuery = true)
    String getStudentByEmailAddressNativeParam(@Param("email_id") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update t_student set first_name = ?1 where email_id =?2",
            nativeQuery = true)
    int updateFirstNameByEmailAddress(String firstName, String emailId);
}
