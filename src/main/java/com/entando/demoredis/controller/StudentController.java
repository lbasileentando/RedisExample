package com.entando.demoredis.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entando.demoredis.Student;
import com.entando.demoredis.service.StudentService;

import org.slf4j.Logger;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents(){
        logger.info("Heeeere we are....");
        ResponseEntity<List<Student>> rez;
        try {
            rez=ResponseEntity.ok().body(studentService.getStudents());
        } catch(Exception e){
            logger.error(e.getLocalizedMessage(), e);
            rez=ResponseEntity.internalServerError().body(null);
        }

        return rez;
         
    };

    @PostMapping("/student")
    ResponseEntity<Student>saveStudent(@RequestBody Student student){
        ResponseEntity<Student> rezStudent;
        try {
            rezStudent=ResponseEntity.ok().body(studentService.addStudent(student));
        } 
        catch(Exception e){
            rezStudent=ResponseEntity.internalServerError().body(null);
        }
        return rezStudent;
    }

    @DeleteMapping("/student")
    ResponseEntity<String> deleteAll(){
       studentService.deleteAll();

       return ResponseEntity.ok().body("everything cleaned!");
    }
}
