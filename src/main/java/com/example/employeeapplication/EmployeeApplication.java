package com.example.employeeapplication;

import com.example.employeeapplication.entity.Address;
import com.example.employeeapplication.entity.Employee;
import com.example.employeeapplication.entity.Project;
import com.example.employeeapplication.entity.Spouse;
import com.example.employeeapplication.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

    @Bean
    public CommandLineRunner initialCreate(EmployeeService employeeService) {
        return args -> {

            Address address1 = new Address("Line1", "Line2", "Zipcode1", "City1", "State1", "Country1");
            Project project1 = new Project("Name1", "Clien Name1");
            Spouse spouse1 = new Spouse("Name1", "Mobile1", 30);

            Employee employee = new Employee("Employee1", "City1");
            employee.addProject(project1);
            employee.addAddress(address1);
            employee.setSpouse(spouse1);

            employeeService.createEmployee(employee);

            System.out.println("Getting an employee");
            Employee employee1 = employeeService.getAnEmployee(1);
        };
    }

}
