package com.dailycodewithbuffer.spring.data.jpa.tutorial.repository;

import com.dailycodewithbuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodewithbuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher()
    {
        Course course1= Course.builder()
                 .title("DBA")
                .credit(9)
               // .teacher(null)
                .build();
        Course course2= Course.builder()
                .title("O.S")
                .credit(4)
               // .teacher(null)
                .build();
        Teacher teacher=Teacher.builder()
                .firstName("Amit")
                .lastName("Kundal")
               // .courses(List.of(course1,course2))
                .build();
        teacherRepository.save(teacher);

    }

}