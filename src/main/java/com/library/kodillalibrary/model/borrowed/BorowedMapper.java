package com.library.kodillalibrary.model.borrowed;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.dao.BorowedDao;
import com.library.kodillalibrary.model.reader.Reader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BorowedMapper {

    public Borowed mapToBorowed(BorowedDto borowedDto) {
        Borowed borowed = new Borowed(borowedDto.getBeginBorrow(), borowedDto.getEndBorrow());
        borowed.setId((long) 0);
        CopyBooks copyBooks = new CopyBooks();
        copyBooks.setId(borowedDto.getCopyBooksId());
        borowed.setCopyBooks(copyBooks);
        Reader reader = new Reader();
        reader.setId(borowedDto.getRederId());
        borowed.setReader(reader);
        return borowed;
    }

    public List<BorowedDto> mapToDtoList(final List<Borowed> borows) {
        List<Borowed> boroweds = borows;
        List<BorowedDto> borowedDtos = new ArrayList<>();
        for (Borowed borowed : boroweds) {
            BorowedDto borowedDto = new BorowedDto();
            borowedDto.setBeginBorrow(borowed.getBeginBorrow());
            borowedDto.setEndBorrow(borowed.getEndBorrow());
            borowedDto.setId(borowed.getId());
            borowedDto.setReaderName("id: " + borowed.getReader().getId() + "; UserName: " + borowed.getReader().getName() + "; UserSurname: " + borowed.getReader().getSurname());
            borowedDto.setCoopyBooksPosition("title: " + borowed.getCopyBooks().getTitle().getTitleName() + "; CopyBooks_ID: " + borowed.getCopyBooks().getId());

            borowedDtos.add(borowedDto);
        }
        return borowedDtos;
    }

    public BorowedDto mapToBorrowedDto(final Borowed borowed) {
        BorowedDto borowedDto = new BorowedDto();
        borowedDto.setBeginBorrow(borowed.getBeginBorrow());
        borowedDto.setEndBorrow(borowed.getEndBorrow());
        borowedDto.setId(borowed.getId());
        borowedDto.setReaderName("id: " + borowed.getReader().getId() + "; UserName: " + borowed.getReader().getName() + "; UserSurname: " + borowed.getReader().getSurname());
        borowedDto.setCoopyBooksPosition("title: " + borowed.getCopyBooks().getTitle().getTitleName() + "; CopyBooks_ID: " + borowed.getCopyBooks().getId());
        return borowedDto;
    }
}
