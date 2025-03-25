package org.example.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.example.springdata.persistence.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TestController {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final ProjectRepository projectRepository;

    @GetMapping
    public void test() {
    }
}
