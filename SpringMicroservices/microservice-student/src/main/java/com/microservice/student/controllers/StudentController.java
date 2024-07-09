package com.microservice.student.controllers;

import com.microservice.student.entities.Student;
import com.microservice.student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudents()
    {
        return ResponseEntity.ok(studentService.findAll());
    }



    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Student student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

}
