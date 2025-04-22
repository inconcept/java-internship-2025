package org.example.springdata.service;

import lombok.RequiredArgsConstructor;
import org.example.springdata.criteria.EmployeeSearchCriteria;
import org.example.springdata.dto.EmployeeDto;
import org.example.springdata.dto.PageResponseDto;
import org.example.springdata.persistence.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public PageResponseDto<EmployeeDto> getAll(EmployeeSearchCriteria criteria) {
        Page<EmployeeDto> page = employeeRepository.findAll(
                criteria,
                criteria.buildPageRequest()
        );

        return PageResponseDto.from(page);
    }
}
