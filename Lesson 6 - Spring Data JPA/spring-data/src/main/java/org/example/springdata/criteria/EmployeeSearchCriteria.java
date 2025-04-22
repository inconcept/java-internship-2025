package org.example.springdata.criteria;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Setter
@Getter
public class EmployeeSearchCriteria extends SearchCriteria {

    private String firstName;
    private String lastName;
    private String email;
    private String companyName;

    @Override
    public PageRequest buildPageRequest() {
        PageRequest pageRequest = super.buildPageRequest();

        return pageRequest.withSort(
                Sort.by("firstName").descending()
        );
    }
}
