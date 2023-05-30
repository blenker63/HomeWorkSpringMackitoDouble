package com.example.homeworkspringmockitodouble.controller;

import com.example.homeworkspringmockitodouble.service.DepartmentService;
import com.example.homeworkspringmockitodouble.service.Employee;
import com.example.homeworkspringmockitodouble.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentTest {

    @Mock
    EmployeeService employeeServiceMoc;
    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        departmentService = new DepartmentService(employeeServiceMoc);
    }


    @Test
    void employeeMaxSalaryTest() {
        Map<String, Employee> employeeTest = Map.of(
                "Иванов11ИванИванович",
                new Employee("Иванов11", "Иван", "Иванович", 1, 11_000),
                "Петров11ПетрПетрович",
                new Employee("Петров11", "Петр", "Петрович", 2, 15000),
                "Сидоров11СидорСидорович",
                new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000));
        when(employeeServiceMoc.getEmployeeData()).thenReturn(employeeTest);
        assertNotNull(departmentService.employeeMaxSalary(2));
        assertEquals(employeeTest.get("Сидоров11СидорСидорович"), departmentService.employeeMaxSalary(1));
    }

    @Test
    void employeeMinSalaryTest() {
        Map<String, Employee> employeeTest = Map.of(
                "Иванов11ИванИванович",
                new Employee("Иванов11", "Иван", "Иванович", 1, 11_000),
                "Петров11ПетрПетрович",
                new Employee("Петров11", "Петр", "Петрович", 2, 15000),
                "Сидоров11СидорСидорович",
                new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000));
        when(employeeServiceMoc.getEmployeeData()).thenReturn(employeeTest);
        assertNotNull(departmentService.employeeMinSalary(2));
        assertEquals(employeeTest.get("Иванов11ИванИванович"), departmentService.employeeMinSalary(1));
    }

    @Test
    void employeeSumSalaryTest() {
        Map<String, Employee> employeeTest = Map.of(
                "Иванов11ИванИванович",
                new Employee("Иванов11", "Иван", "Иванович", 1, 11_000),
                "Петров11ПетрПетрович",
                new Employee("Петров11", "Петр", "Петрович", 2, 15000),
                "Сидоров11СидорСидорович",
                new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000));
        when(employeeServiceMoc.getEmployeeData()).thenReturn(employeeTest);
        var expected = 24000;
        assertNotNull(departmentService.employeeMinSalary(2));
        assertEquals(expected, departmentService.employeeSumSalary(1));

    }

    @Test
    void employeePrintTest() {
        Map<String, Employee> employeeTest = Map.of(
                "Иванов11ИванИванович",
                new Employee("Иванов11", "Иван", "Иванович", 1, 11_000),
                "Петров11ПетрПетрович",
                new Employee("Петров11", "Петр", "Петрович", 2, 15000),
                "Сидоров11СидорСидорович",
                new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000));
        when(employeeServiceMoc.getEmployeeData()).thenReturn(employeeTest);
        var expected = List.of(
//               new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000),
//               new Employee("Иванов11", "Иван", "Иванович", 1, 11_000));
                new Employee("Петров11", "Петр", "Петрович", 2, 15000));
        var actual = departmentService.employeePrintDepartment(2);
        assertEquals(1, actual.size());
        assertIterableEquals(expected, actual);
    }
}