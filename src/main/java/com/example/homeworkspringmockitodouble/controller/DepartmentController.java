package com.example.homeworkspringmockitodouble.controller;

import com.example.homeworkspringmockitodouble.service.DepartmentService;
import com.example.homeworkspringmockitodouble.service.Employee;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
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

    @GetMapping("{id}//sum")
    public String employeeSumSalary(@PathVariable(value = "departmentID") Integer department) {
        return "Сумма зарплат департамента - " + department + ": " + String.valueOf(departmentService.employeeSumSalary(department)) + "рублей";
    }

    @GetMapping(path = "/employee/1")
    public Map<Integer, List<Employee>> allEmployeeDepartment() {
        return departmentService.allEmployeeDepartment();
    }
}

