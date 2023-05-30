package com.example.homeworkspringmockitodouble.service;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
    public int  employeeMaxSalary(int department) {
        return employeeService.getEmployeeData()
                .stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
//                .mapToInt(Employee :: getSalary)
//                .max();
                .max(Comparator.comparingInt(Employee :: getSalary))
                .orElse(null);
    }

    public Optional<Employee> employeeMinSalary(int department) {
        return employeeService.employeeData.values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary));
    }

    public List<Employee> employeePrintAll() {
        return employeeService.employeeData.values().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }

    public List<Employee> employeePrintDepartment(int department) {
        return employeeService.employeeData.values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .collect(Collectors.toList());
    }
    public int employeeSumSalary(int department) {
        return employeeService.employeeData.values().stream()
                .filter(employeeData -> employeeData.getDepartment() == department)
                .mapToInt( Employee :: getSalary)
                .sum();
    }
//    public Map<Integer, List<Employee>> allEmployeeDepartment() {
//         return employeeService.employeeMap().values().stream()
//                 .collect(Collectors.groupingBy(Employee :: getDepartment));
////                 .collect(Collectors.groupingBy(Employee :: getDepartment,
////                         Collectors.mapping(Employee :: getSurname, Collectors.toSet())));
//        }
}
