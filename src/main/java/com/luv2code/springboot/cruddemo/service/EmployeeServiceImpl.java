package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()) {
            throw new RuntimeException("Student not found under id - " + id);
        }
        return optionalEmployee.get();
    }

    @Transactional
    @Override
    public Employee update(int id, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()) {
            throw new RuntimeException("Student not found under id - " + id);
        }
        Employee updatedEmployee = optionalEmployee.get();
        if(employee.getFirstName() != null) {
            updatedEmployee.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName() != null) {
            updatedEmployee.setLastName(employee.getLastName());
        }
        if(employee.getEmail() != null) {
            updatedEmployee.setEmail(employee.getEmail());
        }
        return employeeRepository.save(updatedEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()) {
            throw new RuntimeException("Student not found under id - " + id);
        }
        employeeRepository.deleteById(id);
    }
}
