package com.dailycodewithbuffer.spring.data.jpa.tutorial.repository;

import com.dailycodewithbuffer.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String pattern);

    public List<Student> findByLastNameOrderByFirstName(String lastName);

    public List<Student> findByGuardianName(String guardianName);

    @Query("Select s from Student s where s.emailId=?1")
    public Student getStudentByEmailAddress(String emailId);

    @Query(value = "Select * from tbl_student where email_id=?1",nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);

    @Query(value = "Select * from tbl_student where email_id=:emailId",nativeQuery = true)
    Student getStudentByEmailAddressNativeParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name=?1 where email_id=?2",nativeQuery = true)
    public int updateStudentNameByEmailId(String firstName,String emailId);
}
