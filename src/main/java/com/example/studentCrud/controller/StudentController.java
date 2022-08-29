package com.example.studentCrud.controller;

import com.example.studentCrud.model.Student;
import com.example.studentCrud.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Void> createStudent(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<Student>> listAll() {
        List<Student> allStudent = studentService.listAll();

        return ResponseEntity.ok(allStudent);
    }

    @GetMapping("/getByStudentId")
    public ResponseEntity<Student> getByStudentId(@RequestParam("id") Long id) {
        Student student = studentService.getByStudentId(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/delByStudentId")
    public ResponseEntity<Void> delByStudentId(@RequestParam("id") Long id) {
        studentService.delByStudentId(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @GetMapping("/getByStudentFirstLetter")
    public ResponseEntity<List<Student>> getByStudentFirstLetter() {
        List<Student> students = studentService.getStudentByFirstLetter();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/getByStudentThirdLetter")
    public ResponseEntity<List<Student>> getByStudentThirdLetter() {
        List<Student> students = studentService.getStudentByThirdLetter();
        return ResponseEntity.ok(students);
    }
}