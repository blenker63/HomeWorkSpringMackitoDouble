package com.example.homeworkspringmockitodouble.service;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String massage) {
        super(massage);
    }
}
