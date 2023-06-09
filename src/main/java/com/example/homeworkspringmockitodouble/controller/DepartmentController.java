package com.example.homeworkspringmockitodouble.controller;

import com.example.homeworkspringmockitodouble.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/max-salary")

    public String employeeMaxSalary(@RequestParam(required = false, value = "departmentID") Integer department) {
        if (department == null)
            throw new RuntimeException("Данные введены не полностью");
        else
            return "Сотрудник департамента - " + department + " с максимальной зарплатой - " + String.valueOf(departmentService.employeeMaxSalary(department));
    }

    @GetMapping(path = "/min-salary")
    public String employeeMinSalary(@RequestParam(required = false, value = "departmentID") Integer department) {
        return "Сотрудник департамента - " + department + " с минимальной зарплатой - " + String.valueOf(departmentService.employeeMinSalary(department));
    }

    @GetMapping(path = "/all")
    public String employeePrint(@RequestParam(required = false, value = "departmentID") Integer department) {
        if (department == null) {
            return departmentService.employeePrintAll().toString();
        } else {
            return departmentService.employeePrintDepartment(department).toString();
        }
    }
}

