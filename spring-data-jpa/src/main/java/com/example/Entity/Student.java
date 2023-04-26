package com.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_student",
        schema = "schooldb",
                    uniqueConstraints ={
                                        @UniqueConstraint
                                                (name = "emailId_unique",
                                                        columnNames = "emailId"
                                                )
                                        }
        )
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    @SequenceGenerator(
                        name = "student_generator",
                        sequenceName = "student_sequence",
                        allocationSize = 1
                        )
    private Long studentId;
    private String firstName;
    private String lastName;
    private String emailId;

//    @Column(name = "guardian_name", nullable = false)
//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;

    @Embedded
    Guardian guardian;

}
