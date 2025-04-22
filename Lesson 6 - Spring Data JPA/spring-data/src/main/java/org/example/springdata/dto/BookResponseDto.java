package org.example.springdata.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookResponseDto {

    private Long id;
    private String name;
    private String author;
}
