package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
    Employee update(int id, Employee employee);
    void deleteById(int id);
}
