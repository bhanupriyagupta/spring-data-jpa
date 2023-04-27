package com.example.Repository;

import com.example.Entity.Course;
import com.example.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    Course course =
            Course.builder()
                    .title(".net")
                    .credit(6)
                    .build();
    Course course1 =
            Course.builder()
                    .title("java")
                    .credit(7)
                    .build();



    @Test
    public void saveTeacher(){
        Teacher teacher=Teacher.builder()
                .firstName("Shalini")
                .lastName("Malhotra")
                .courseList(Arrays.asList(course,course1))
                .build();

        teacherRepository.save(teacher);



    }

}