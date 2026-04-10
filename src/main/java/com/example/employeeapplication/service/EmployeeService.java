package com.example.employeeapplication.service;

import com.example.employeeapplication.entity.Employee;
import com.example.employeeapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "First Employee", "Washington"),
            new Employee(2, "Second Employee", "New York")
    ));

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getAnEmployee(int id) {
        return employeeList.stream().filter(employee -> (
                employee.getEmployeeId() == id)).findFirst().get();
    }

    public void createEmployee(Employee employee) {
        //employeeList.add(employee);
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        List<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == employee.getEmployeeId()) {
                emp.setEmployeeName(employee.getEmployeeName());
                emp.setEmployeeCity(employee.getEmployeeCity());
            }
            tempEmployee.add(emp);
        }
        this.employeeList = tempEmployee;
    }

    public void deleteEmployee(int id) {
        List<Employee> tempEmployee = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getEmployeeId() == id)
                continue;
            tempEmployee.add(emp);
        }
        this.employeeList = tempEmployee;
    }

}
