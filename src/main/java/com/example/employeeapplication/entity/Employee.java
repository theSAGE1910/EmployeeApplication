package com.example.employeeapplication.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer employeeId;
    String employeeName;
    String employeeCity;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "fk_spouse")
    private Spouse spouse;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Address> addresses;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name = "employee_project",
    joinColumns = @JoinColumn(name = "fk_employee"),
    inverseJoinColumns = @JoinColumn(name = "fk_project"))
    private List<Project> projects;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeCity = employeeCity;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public Spouse getSpouse() {
        return spouse;
    }

    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getEmployees().remove(project);
    }

    public void addProject(Project project) {
        this.projects.add(project);
        project.getEmployees().add(this);
    }
}
