package org.example.springdata.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
public class PageResponseDto<T> {

    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalElements;

    public static <T> PageResponseDto<T> from(Page<T> page) {
        PageResponseDto<T> pageResponseDto = new PageResponseDto<>();

        pageResponseDto.setContent(page.getContent());
        pageResponseDto.setPageSize(page.getPageable().getPageSize());
        pageResponseDto.setPageNumber(page.getPageable().getPageNumber());
        pageResponseDto.setTotalPages(page.getTotalPages());
        pageResponseDto.setTotalElements(page.getTotalElements());

        return pageResponseDto;
    }
}
