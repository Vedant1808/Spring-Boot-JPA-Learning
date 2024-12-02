package com.dailycodewithbuffer.spring.data.jpa.tutorial.repository;

import com.dailycodewithbuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodewithbuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodewithbuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses()
    {
        List<Course> courses=courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher()
    {
        Teacher teacher= Teacher.builder()
                .firstName("Abhishek")
                .lastName("Sharma")
                .build();
        Course course=Course.builder()
                .title("Python")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination()
    {
        Pageable firstPageWith3Records=PageRequest.of(0,3);
        Pageable secondPageWith3Records=PageRequest.of(1,2);

        List<Course> courses=courseRepository
                .findAll(firstPageWith3Records)
                .getContent();

        long totalElements=courseRepository.findAll(firstPageWith3Records).getTotalElements();

        long totalPages=courseRepository.findAll(firstPageWith3Records).getTotalPages();

        System.out.println(courses);
        System.out.println(totalElements);
        System.out.println(totalPages);
    }

    @Test
    public void findAllSorting()
    {
        Pageable sortByTitle=PageRequest.of(0,4,Sort.by("title"));
        Pageable sortByCreditDescending=PageRequest.of(0,5,Sort.by("credit").descending());

        List<Course> courses= (List<Course>) courseRepository.findAll(sortByTitle).getContent();
        List<Course> courses1= (List<Course>) courseRepository.findAll(sortByCreditDescending).getContent();
        System.out.println(courses);
        System.out.println(courses1);
    }

    @Test
    public void printFindByTitleContaining()
    {
        Pageable firstPageTenRecords=
                PageRequest.of(0,10);
        List<Course> courses=courseRepository.findByTitleContaining("A",firstPageTenRecords).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher()
    {
        Teacher teacher=Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();
        Student student= Student.builder()
                .firstName("Mohan")
                .emailId("mohan@gmail.com")
                .lastName("Sharma")
                .build();
        Course course=Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        courseRepository.save(course);

    }

}