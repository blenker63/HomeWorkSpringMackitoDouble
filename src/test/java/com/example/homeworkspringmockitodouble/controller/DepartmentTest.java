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

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

//    @Test
//    void employeeMaxSalaryTest() {
//        List<Employee> employees= List.of(
//                new Employee("Иванов11", "Иван", "Иванович", 1, 11_000),
//                new Employee("Петров11", "Петр", "Петрович", 2, 15000),
//                new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000));
//        when(employeeServiceMoc.getEmployeeData()).thenReturn();
//
//    }
//
//}

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
        var expectedMaxSalary = new Employee("Сидоров11", "Сидор", "Сидорович", 1, 13000);
        assertEquals(employeeTest.get("Сидоров11СидорСидорович"), departmentService.employeeMaxSalary(1));
    }
}