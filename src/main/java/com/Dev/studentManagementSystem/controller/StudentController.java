package com.Dev.studentManagementSystem.controller;

import com.Dev.studentManagementSystem.modal.Student;
import com.Dev.studentManagementSystem.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student){
        service.addStudent(student);
       return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<>(service.getAllStudent(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student = service.getStudentById(id);
        if(student != null)
        return new ResponseEntity<>(student,HttpStatus.OK);

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateStudent(@Valid @RequestBody Student student, @PathVariable int id){

        boolean updated = service.updateStudent(student, id);

        if(updated){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        else return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable int id){

       boolean delete =  service.deleteStudent(id);

       if(delete) return new ResponseEntity<>(true,HttpStatus.OK);
       else return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);

    }

}
