package org.example.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.example.springdata.criteria.EmployeeSearchCriteria;
import org.example.springdata.dto.EmployeeDto;
import org.example.springdata.dto.PageResponseDto;
import org.example.springdata.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public PageResponseDto<EmployeeDto> getAll(EmployeeSearchCriteria criteria) {
        return employeeService.getAll(criteria);
    }
}
