package com.microservice.course.controllers;

import com.microservice.course.entities.Course;
import com.microservice.course.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses()
    {
        return ResponseEntity.ok(courseService.findAll());
    }



    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Course course = courseService.findById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/search-students/{idCourse}")
    public ResponseEntity<?> findAllStudentsByIdCourse(@PathVariable Long idCourse)
    {
        return ResponseEntity.ok(courseService.findAllStudentsByIdCourse(idCourse));
    }

}
