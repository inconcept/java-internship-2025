package org.example.springdata.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookUpdateDto {

    @NotBlank
    private String name;

    @NotBlank
    private String author;
}
