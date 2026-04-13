package com.example.employeeapplication.service;

import com.example.employeeapplication.entity.Address;
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
//        return employeeList;
        return employeeRepository.findAll();
    }

    public Employee getAnEmployee(int id) {
//        return employeeList.stream().filter(employee -> (
//                employee.getEmployeeId() == id)).findFirst().get();
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found!"));
    }

    public void createEmployee(Employee employee) {
        //employeeList.add(employee);
        ArrayList<Address> addressArrayList = new ArrayList<>();

        for (Address address : employee.getAddresses()) {
            addressArrayList.add(new Address(
                    address.getLine1(),
                    address.getLine2(),
                    address.getZipCode(),
                    address.getCity(),
                    address.getState(),
                    address.getCountry(),
                    employee
            ));
        }
        employee.setAddresses(addressArrayList);

        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
//        List<Employee> tempEmployee = new ArrayList<>();
//        for (Employee emp : employeeList) {
//            if (emp.getEmployeeId() == employee.getEmployeeId()) {
//                emp.setEmployeeName(employee.getEmployeeName());
//                emp.setEmployeeCity(employee.getEmployeeCity());
//            }
//            tempEmployee.add(emp);
//        }
//        this.employeeList = tempEmployee;
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
//        List<Employee> tempEmployee = new ArrayList<>();
//        for (Employee emp : employeeList) {
//            if (emp.getEmployeeId() == id)
//                continue;
//            tempEmployee.add(emp);
//        }
//        this.employeeList = tempEmployee;
        employeeRepository.delete(employeeRepository.getById(id));
    }

}
