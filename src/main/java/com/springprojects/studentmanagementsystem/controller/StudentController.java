package com.springprojects.studentmanagementsystem.controller;

import com.springprojects.studentmanagementsystem.model.Student;
import com.springprojects.studentmanagementsystem.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "https://studentmanagementsystem-theta.vercel.app/")
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentServices;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentServices.getStudents(), HttpStatus.FOUND);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentServices.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentServices.updateStudent(student,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable  Long id){
        studentServices.deleteStudent(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        return  studentServices.getStudentById(id);
    }
}
