package com.entando.demoredis.repository;

import org.springframework.data.repository.CrudRepository;

import com.entando.demoredis.Model.Student;

public interface StudentRepository extends CrudRepository<Student, String> {
}
