package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "http://localhost:8090/api/students")
public interface StudentClient {

//    este metodo se encuentra en el microservicio de estudiante, debe ser tener el mismo nombre y parametros
    @GetMapping("/search-my-course/{idCourse}")
    List<StudentDTO> findAllStudentsByIdCourse(@PathVariable Long idCourse);

}
