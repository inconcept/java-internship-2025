package org.example.springdata.controller;

import jakarta.validation.Valid;
import org.example.springdata.dto.BookCreateDto;
import org.example.springdata.dto.BookResponseDto;
import org.example.springdata.dto.BookUpdateDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookResponseDto create(@RequestBody @Valid BookCreateDto bookCreateDto) {
        return null;
    }

    @GetMapping("/{id}")
    public BookResponseDto getbyId(@PathVariable() Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @Valid @RequestBody BookUpdateDto bookUpdateDto) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
    }

    @PostMapping("/{bookId}/genres/{genreId}")
    public void addGenreToBook(@PathVariable("bookId") Long bookId,
                               @PathVariable("genreId") Long genreId) {
    }

    @GetMapping("/{id}/genres")
    public Object getBookGenres(@PathVariable Long id) {
        return null;
    }
}
