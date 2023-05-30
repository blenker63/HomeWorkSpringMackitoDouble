package com.example.homeworkspringmockitodouble.service;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String massage) {
        super(massage);
    }
}
