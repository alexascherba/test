package com.scherba.test.service;

import com.scherba.test.dto.BookDto;

import java.util.List;

public interface BookService {
    /*void addBook(BookDto bookDto);
    List<BookDto> getAllBooks();
    BookDto getBookById(Long id);*/
    void updateBook(Long id, BookDto bookDto);
    void deleteBook(Long id);
}
