package com.scherba.test;

import com.scherba.test.dto.BookDto;
import com.scherba.test.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "libraryId", source = "library.id")
    BookDto toDto(Book book);

    @Mapping(target = "library", source = "libraryId")
    Book toEntity(BookDto bookDto);
}
