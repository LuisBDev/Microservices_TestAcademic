package com.microservice.student.services.impl;

import com.microservice.student.entities.Student;
import com.microservice.student.persistence.IStudentRepository;
import com.microservice.student.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return (List<Student>)studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findAllStudentsByIdCourse(Long courseId) {
        return studentRepository.findAllByCourseId(courseId);
    }
}
