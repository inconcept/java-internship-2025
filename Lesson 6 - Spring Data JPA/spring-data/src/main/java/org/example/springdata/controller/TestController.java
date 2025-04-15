package org.example.springdata.controller;


import lombok.RequiredArgsConstructor;
import org.example.springdata.enums.ProjectStatus;
import org.example.springdata.persistence.entity.Company;
import org.example.springdata.persistence.entity.Employee;
import org.example.springdata.persistence.entity.Project;
import org.example.springdata.persistence.repository.CompanyRepository;
import org.example.springdata.persistence.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;


@RestController
@RequiredArgsConstructor
public class TestController {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    @GetMapping
    public void test() {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            Employee employee = new Employee();
            employee.setFirstName("FirstName" + i);
            employee.setLastName("LastName" + i);
            employee.setEmail("email" + i + "@example.com");

            employees.add(employee);
        }

        employeeRepository.saveAll(employees);
    }

    @GetMapping("/1")
    public void test1() {
        List<Employee> employees = new ArrayList<>();
        Set<String> existingEmployeeEmails = employeeRepository.findAllEmails();

        for (int i = 0; i < 2_000_000; i++) {
            String email = "email" + i + "@example.com";
            if (existingEmployeeEmails.contains(email)) {
                System.out.println(i);
                continue;
            }

            Employee employee = new Employee();
            employee.setFirstName("FirstName" + i);
            employee.setLastName("LastName" + i);
            employee.setEmail(email);

            employees.add(employee);
        }

        employeeRepository.saveAll(employees);
    }

    @GetMapping("/2")
    public void test2() {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 200_000; i++) {
            Employee employee = new Employee();
            employee.setFirstName("FirstName" + i);
            employee.setLastName("LastName" + i);
            employee.setEmail("email" + i + "@example.com");

            Company company = new Company();
            company.setName("CompanyName" + i);
            company.setFoundationDate(LocalDate.now());

            company.addEmployee(employee);

            employees.add(employee);
        }

        employeeRepository.saveAll(employees);
    }

    @GetMapping("/3")
    public void test3() {
        List<Employee> employees = new ArrayList<>();
        List<Company> companies = companyRepository.findAll();
        Map<String, Company> companiesByName = new HashMap<>();
        for (Company company : companies) {
            companiesByName.put(company.getName(), company);
        }

        for (int i = 0; i < 200_000; i++) {
            Employee employee = new Employee();
            employee.setFirstName("FirstName" + i);
            employee.setLastName("LastName" + i);
            employee.setEmail("email" + i + "@example.com");

            String companyName = "CompanyName" + i;

            Company employeeCompany = getEmployeeCompany(companyName, companiesByName);

            employeeCompany.addEmployee(employee);

            employees.add(employee);
        }

        employeeRepository.saveAll(employees);
    }

    private Company getEmployeeCompany(String companyName, Map<String, Company> companiesByName) {
        if (companiesByName.containsKey(companyName)) {
            return companiesByName.get(companyName);
        }

        Company company = new Company();
        company.setName(companyName);
        company.setFoundationDate(LocalDate.now());

        return company;
    }

    @GetMapping("/4")
    public void test4() {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            Employee employee = new Employee();
            employee.setFirstName("FirstName" + i);
            employee.setLastName("LastName" + i);
            employee.setEmail("email" + i + "@example.com");

            Project project = new Project();
            project.setName("ProjectName" + i);
            project.setStatus(ProjectStatus.IN_PROGRESS);

            employee.addEmployeeProject(project);

            employees.add(employee);
        }

        employeeRepository.saveAll(employees);
    }
}
