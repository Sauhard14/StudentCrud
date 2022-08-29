package com.example.studentCrud.repository;


import com.example.studentCrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository  extends JpaRepository<Student, Long> {

    @Query(value = "select * from student where name like 'J%'" , nativeQuery = true)
    public List<Student> getStudentBySecLetter();


}
