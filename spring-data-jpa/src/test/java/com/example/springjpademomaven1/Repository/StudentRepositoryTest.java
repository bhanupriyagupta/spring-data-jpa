package com.example.springjpademomaven1.Repository;

import com.example.Entity.Guardian;
import com.example.Entity.Student;
import com.example.Repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .firstName("gaurav")
                .lastName("gupta")
                .emailId("g@g.com")
               // .guardianEmail("aa1@aa1.com")
                //.guardianName("Aarush1")
                //.guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("gaurav1")
                .email("g1@gg.com")
                .mobile("999987967")
                .build();

        Student student = Student.builder()
                .firstName("kishmish1")
                .lastName("gupta1")
                .emailId("k1@k.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    
    @Test
    public void getStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("bhanu");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void getStudentByFirstNameContaining(){
        List<Student> studentListContaining = studentRepository.findByFirstNameContaining("aa");
        System.out.println("studentListContaining = " + studentListContaining);
    }
    @Test
    public void getStudentByGuardianName(){
        List<Student> studentListWithGuardian = studentRepository.findByGuardianName("gaurav");
        System.out.println("studentListWithGuardian = " + studentListWithGuardian);
    }
    @Test
    public void getStudentByLastNameNotNull(){
        List<Student> studentListWithLastNameNotNull = studentRepository.findByLastNameNotNull();
        System.out.println("studentListWithLastNameNotNull = " + studentListWithLastNameNotNull);
    }
    @Test
    public void getStudentByEmailIdBasedOnQuery(){
        Student student = studentRepository.getStudentByEmailId("k@k.com");
        System.out.println("student = " + student);
    }


}