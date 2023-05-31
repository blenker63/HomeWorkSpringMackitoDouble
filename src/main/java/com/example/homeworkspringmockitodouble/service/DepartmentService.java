package com.example.homeworkspringmockitodouble.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee employeeMaxSalary(int department) {
        return employeeService.getEmployeeData().values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee employeeMinSalary(int department) {
        return employeeService.getEmployeeData().values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public int employeeSumSalary(int department) {
        return employeeService.getEmployeeData().values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public Collection<Employee> employeePrintAll() {
        return employeeService.getEmployeeData().values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    public Collection<Employee> employeePrintDepartment(Integer department) {
        return employeeService.getEmployeeData().values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> allEmployeeDepartment() {
        return employeeService.getEmployeeData().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
