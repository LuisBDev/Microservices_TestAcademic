package com.microservice.course.services.impl;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import com.microservice.course.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>)courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Course course) {

        courseRepository.save(course);
    }

    @Override
    public StudentsByCourseResponse findAllStudentsByIdCourse(Long idCourse) {
//        Consultar el curso
        Course course = courseRepository.findById(idCourse).orElse(new Course());

//        Obtener los estudiantes del curso
        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByIdCourse(idCourse);

        return StudentsByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
