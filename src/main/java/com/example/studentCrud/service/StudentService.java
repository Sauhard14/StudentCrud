package com.example.studentCrud.service;

import com.example.studentCrud.model.Student;
import com.example.studentCrud.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void save(Student student){
        studentRepository.save(student);
    }

    public List<Student> listAll(){
        List<Student> allStudents = studentRepository.findAll();
        return allStudents;
    }

    public Student getByStudentId(Long StudentId){
        Student student = studentRepository.findById(StudentId).orElse(new Student());
        return student;
    }

    public void delByStudentId(Long studentId){
       studentRepository.deleteById(studentId);
    }

    public List<Student> getStudentByFirstLetter(){
        List<Student> allStudents = studentRepository.getByStudentFirstLetter();
        return allStudents;
    }
    public List<Student> getStudentByThirdLetter(){
        List<Student> s1 = studentRepository.getByStudentThirdLetter();
        return s1;
    }



 }
