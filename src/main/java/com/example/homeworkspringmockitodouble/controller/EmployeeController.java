package com.example.homeworkspringmockitodouble.controller;

import com.example.homeworkspringmockitodouble.service.EmployeeService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam(value = "surname", required = false) String surname,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "patronymic", required = false) String patronymic,
                              @RequestParam(value = "department", required = false) int department,
                              @RequestParam(value = "salary", required = false) int salary) {
        if (surname == null || name == null || patronymic == null || department < 1 || salary < 1)
            throw new RuntimeException("Данные введены не полностью");
        else if (!StringUtils.isEmpty(surname) || !StringUtils.isEmpty(name) || !StringUtils.isEmpty(patronymic)) {
            throw new RuntimeException("400 Bad Request");
        } else
            surname = StringUtils.capitalize(surname);
        name = StringUtils.capitalize(name);
        patronymic = StringUtils.capitalize(patronymic);
        return "Добавлен сотрудник: " + employeeService.addEmployee(surname, name, patronymic, department, salary);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam(required = false, value = "surname") String surname,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "patronymic", required = false) String patronymic) {
        if (surname == null || name == null || patronymic == null)
            throw new RuntimeException("Данные введены не полностью");

        return "Удален сотрудник - " + employeeService.removeEmployee(surname, name, patronymic);

    }

    @GetMapping(path = "/get")
    public String getEmployee(@RequestParam(required = false, value = "surname") String surname,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "patronymic", required = false) String patronymic) {
        return "Найден сотрудник: " + employeeService.getEmployee(surname, name, patronymic);
    }
}
