package com.example.homeworkspringmockitodouble.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService= employeeService;
    }

    //    private final Map<String, Employee> employeeDataDep = new HashMap<>();
//
//    public Optional <Employee> employeeMaxSalary(int department) {
//    public Employee employeeMaxSalary(int department) {
    public Employee  employeeMaxSalary(int department) {
        return employeeService.getEmployeeData().values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .max(Comparator.comparingInt(Employee :: getSalary))
                .orElse(null);
    }

    public Employee employeeMinSalary(int department) {
        return employeeService.getEmployeeData().values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .min(Comparator.comparingInt(Employee :: getSalary))
                .orElse(null);
    }
    public int employeeSumSalary(int department) {
        return employeeService.getEmployeeData().values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .mapToInt( Employee :: getSalary)
                .sum();
    }
    public Collection<Employee> employeePrintAll() {
        return employeeService.getEmployeeData().values().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    public Collection<Employee> employeePrintDepartment(int department) {
        return employeeService.getEmployeeData().values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .collect(Collectors.toList());
    }

//    public Map<Integer, List<Employee>> allEmployeeDepartment() {
//         return employeeService.employeeMap().values().stream()
//                 .collect(Collectors.groupingBy(Employee :: getDepartment));
////                 .collect(Collectors.groupingBy(Employee :: getDepartment,
////                         Collectors.mapping(Employee :: getSurname, Collectors.toSet())));
//        }
}
