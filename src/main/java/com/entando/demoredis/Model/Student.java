package com.entando.demoredis.Model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;
@Data
@RedisHash("Student")
public class Student implements Serializable {
    private String id;
    private String name;
    private Integer age;
}