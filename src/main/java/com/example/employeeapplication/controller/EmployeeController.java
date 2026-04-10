package com.example.employeeapplication.controller;

import com.example.employeeapplication.entity.Employee;
import com.example.employeeapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
//@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //@RequestMapping("/employees")
    //@RequestMapping(value = "/employees", method = RequestMethod.GET)
    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //@RequestMapping("employees/{id}")
    @GetMapping("employees/{id}")
    public Employee findAnEmployee(@PathVariable int id) {
        return employeeService.getAnEmployee(id);
    }

    //@RequestMapping(value = "/employees", method = RequestMethod.POST)
    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
    }

    //@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    @PutMapping("/employees/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    //@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/employees/{id}")
    public List<Employee> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return employeeService.getAllEmployees();
    }
}