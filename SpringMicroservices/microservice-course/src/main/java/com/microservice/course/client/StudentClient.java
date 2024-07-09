package com.microservice.course.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "http://localhost:8090/api/students")
public interface StudentClient {

    @GetMapping("/search-my-course/{idCourse}")
    List<?> findAllStudentsByCourse(@PathVariable Long idCourse);

}
