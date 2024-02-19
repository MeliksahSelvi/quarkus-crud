package com.melik.service;

import com.melik.domain.Employee;
import com.melik.repo.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

/**
 * @Author mselvi
 * @Created 19.02.2024
 */

@ApplicationScoped
public class EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee Not Found!"));
    }

    public void persistEmployee(Employee employee) {
        employeeRepository.persist(employee);
    }

    public Employee updateBook(Employee employee) {
        Employee employeeById = this.findById(employee.getId());
        updateEmployee(employeeById, employee);
        return employeeRepository.save(employeeById);
    }

    private void updateEmployee(Employee employeeToBeUpdated, Employee employeeSource) {
        employeeToBeUpdated.setName(employeeSource.getName());
        employeeToBeUpdated.setSurname(employeeSource.getSurname());
        employeeToBeUpdated.setAge(employeeSource.getAge());
    }
}
