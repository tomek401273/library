package com.library.kodillalibrary.model.copyBooks;

import com.library.kodillalibrary.model.title.Title;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CopyBooksMapper {

    public CopyBooksDto mapToCopyBooksDto(CopyBooks copyBooks) {
        return new CopyBooksDto(copyBooks.getId(), copyBooks.getStatus(),copyBooks.getTitle().getTitleName(),copyBooks.getTitle().getId());
    }

    public CopyBooks mapToCopyBooks(CopyBooksDto copyBooksDto) {

        Title title = new Title();
        title.setId(copyBooksDto.getTitleId());

        CopyBooks copyBooks = new CopyBooks(copyBooksDto.getStatus());
        copyBooks.setTitle(title);
        copyBooks.setId((long)0);
        return copyBooks;
    }
    public CopyBooks mapToCopyBooksUpdate(CopyBooksDto copyBooksDto) {

        Title title = new Title();
        title.setId(copyBooksDto.getTitleId());

        CopyBooks copyBooks = new CopyBooks(copyBooksDto.getStatus());
        copyBooks.setTitle(title);
        System.out.println("Id from mapper Dto: "+copyBooksDto.getId());
        Long id =copyBooksDto.getId();
        copyBooks.setId(id);
        System.out.println("Id from mapper orginal: "+copyBooks.getId());
        return copyBooks;
    }

    public List<CopyBooksDto> mapToCopyDtoList (final List<CopyBooks> copyBooks) {
        return  copyBooks.stream()
                .map(t-> new  CopyBooksDto(t.getId(), t.getStatus(), t.getTitle().getTitleName(),t.getTitle().getId()))
                .collect(Collectors.toList());
    }
}
