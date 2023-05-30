package com.example.homeworkspringmockitodouble.controller;

import com.example.homeworkspringmockitodouble.service.EmployeeAlreadyAddedException;
import com.example.homeworkspringmockitodouble.service.EmployeeNotFoundException;
import com.example.homeworkspringmockitodouble.service.EmployeeService;
import com.example.homeworkspringmockitodouble.service.EmployeeStoragelsFullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    private final EmployeeService employeeService = new EmployeeService();


    @Test
    public void addEmployeeTest() {
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> {
            employeeService.addEmployee("Иванов", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов", "Иван", "Иванович", 1, 11_000);
        });
        Assertions.assertDoesNotThrow(() -> {
            employeeService.addEmployee("Петров1", "Петр", "Петрович", 2, 15000);
        });
//        int number = employeeService.number;
//        number = 2;
//        Assertions.assertEquals(number + 1, employeeService.number + 1);
        Assertions.assertThrows(EmployeeStoragelsFullException.class, () -> {
            employeeService.addEmployee("Иванов1", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов2", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов3", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов4", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов5", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов6", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов7", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов8", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов9", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов10", "Иван", "Иванович", 1, 11_000);
            employeeService.addEmployee("Иванов11", "Иван", "Иванович", 1, 11_000);
        });
    }

    @Test
    public void removeEmployeeTest() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.removeEmployee("Иванов99", "Иван", "Иванович");
//            employeeService.removeEmployee("Иванов", "Иван", "Иванович");
        });
        Assertions.assertDoesNotThrow(() -> {
            employeeService.removeEmployee("Петров", "Петр", "Петрович");
        });
    }
    @Test
    public void getEmployeeTest() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.getEmployee("Петров33", "Петр", "Петрович");
        });
        Assertions.assertDoesNotThrow(() -> {
            employeeService.getEmployee("Степанов", "Григорий", "Михайлович");
        });
    }
}
