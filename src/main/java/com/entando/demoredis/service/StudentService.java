package com.entando.demoredis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entando.demoredis.Student;
import com.entando.demoredis.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getStudents(){
        List<Student> list = new ArrayList<Student>();
        studentRepository.findAll().forEach( i -> {
            list.add(i);
        });
        return list;
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

}
