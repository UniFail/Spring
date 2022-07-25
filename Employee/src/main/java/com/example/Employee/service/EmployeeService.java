package com.example.Employee.service;


import com.example.Employee.domain.Employee;
import com.example.Employee.exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {


    Employee findEmployee(String firstname, String lastname);

    Employee addEmployee(String firstname, String lastname);

    Employee deleteEmployee(String firstname, String lastname);
    List<Employee> getAll();

}
