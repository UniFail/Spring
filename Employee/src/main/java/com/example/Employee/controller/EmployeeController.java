package com.example.Employee.controller;

import com.example.Employee.domain.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstname") String firstname,
                                @RequestParam("lastname") String lastname) {

        return employeeService.findEmployee(firstname,lastname);
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam("firstname") String firstname,
                              @RequestParam("lastname") String lastname) {


        return employeeService.addEmployee(firstname,lastname);
    }

    @GetMapping(path = "/delete")
    public Employee deleteEmployee(@RequestParam("firstname") String firstname,
                                 @RequestParam("lastname") String lastname) {

        return employeeService.deleteEmployee(firstname,lastname);

    }
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
}
