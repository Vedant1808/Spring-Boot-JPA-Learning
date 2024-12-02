package com.dailycodewithbuffer.spring.data.jpa.tutorial.repository;

import com.dailycodewithbuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodewithbuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
  private StudentRepository studentRepository;


    @Test
    public void saveStudent()
    {
      Student student=Student.builder()
              .emailId("Far@gmail.com")
              .firstName("Far")
              .lastName("John")
              //.guardianEmail("shi@gmail.com")
              //.guardianMobile("9999999999")
              //.guardianName("Shi")
              .build();
      studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian()
    {
      Guardian guardian=Guardian.builder()
              .email("piu@gmail.com")
              .mobile("5656565667")
              .name("Piu")
              .build();
      Student student=Student.builder()
              .firstName("Vani")
              .emailId("vani@gmail.com")
              .lastName("Mandloi")
              .guardian(guardian)
              .build();

      studentRepository.save(student);
    }

    @Test
  public void printAllStudents()
    {
      List<Student> students=studentRepository.findAll();
      students.forEach(s->{System.out.println(s);});
    }

    @Test
  public void printStudentByFirstName()
    {
      List<Student> students=studentRepository.findByFirstName("Shivam");
      students.forEach(s->{System.out.println(s);});
    }

    @Test
  public void printStudentByFirstNameLike()
    {
      List<Student> students=studentRepository.findByFirstNameContaining("va");
      students.forEach(s->{System.out.println(s);});
    }

    @Test
  public void printStudentBasedOnGuardianName()
    {
      System.out.println(studentRepository.findByGuardianName("Dipesh"));
    }

    @Test
  public void printStudentBasedOnEmailAddress()
    {
      System.out.println(studentRepository.getStudentByEmailAddress("jatin@gmail.com"));
      System.out.println(studentRepository.getStudentByEmailAddress("a@gmail.com"));
    }

  @Test
  public void printStudentBasedOnEmailAddressNative()
  {
    System.out.println(studentRepository.getStudentByEmailAddressNative("jatin@gmail.com"));
    System.out.println(studentRepository.getStudentByEmailAddressNative("a@gmail.com"));
  }

  @Test
  public void printStudentBasedOnEmailAddressNativeParam()
  {
    System.out.println(studentRepository.getStudentByEmailAddressNativeParam("jatin@gmail.com"));
    System.out.println(studentRepository.getStudentByEmailAddressNativeParam("a@gmail.com"));
  }

  @Test
  public void updateStudentNameByEmailIdTest()
  {
    studentRepository.updateStudentNameByEmailId("abhinav","jatin@gmail.com");
  }
}