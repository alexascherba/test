package com.scherba.test.service;

//import com.scherba.test.BookMapper;
import com.scherba.test.dto.BookDto;
import com.scherba.test.entity.Book;
import com.scherba.test.entity.Library;
import com.scherba.test.repository.BookRepository;
import com.scherba.test.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    //private final BookMapper bookMapper;


    //@Autowired
    public BookServiceImpl(BookRepository bookRepository, LibraryRepository libraryRepository/*, BookMapper bookMapper*/) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
        //this.bookMapper = bookMapper;
    }

    /*@Override
    public void addBook(BookDto bookDto) {
        Library library = libraryRepository.findById(bookDto.getLibraryId())
                .orElseThrow(() -> new RuntimeException("Library not found"));
        Book book = bookMapper.toEntity(bookDto);
        book.setLibrary(library);
        bookRepository.save(book);
    }*/

    /*@Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElse(null);
    }*/

    @Override
    public void updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Library library = libraryRepository.findById(bookDto.getLibraryId())
                .orElseThrow(() -> new RuntimeException("Library not found"));
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublishedDate(bookDto.getPublishedDate());
        book.setLibrary(library);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Library library = new Library();

        bookRepository.deleteById(id);
    }
}
