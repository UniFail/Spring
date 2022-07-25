package com.example.Employee.service;

import com.example.Employee.domain.Employee;
import com.example.Employee.exception.EmployeeAlreadyAddedException;
import com.example.Employee.exception.EmployeeNotFoundException;
import com.example.Employee.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImlp implements EmployeeService{
    private static final int LIMIT = 10;
    private final  List<Employee> employees;


    public EmployeeServiceImlp() {
        this.employees = new ArrayList<>();
    }

    public Employee findEmployee(String firstname, String lastname)  {
      Employee employee = new Employee(firstname,lastname);
      if(!employees.contains(employee)){
          throw new EmployeeNotFoundException("Employee not found");
      }
      return employee;
    }

    public Employee addEmployee(String firstname, String lastname) {
        Employee employee = new Employee(firstname, lastname);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee already added");
        }
        if (employees.size() < LIMIT){
            return employee;
        }
        else {
            throw new EmployeeStorageIsFullException("Employee Storege is full");
        }
    }

    public Employee deleteEmployee(String firstname, String lastname) {
        Employee employee = new Employee(firstname,lastname);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException("Employee not found");
        }
        employees.remove(employee);
        return employee;
    }

    public List<Employee> getAll(){
        return new ArrayList<>(employees);
    }
}
