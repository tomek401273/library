package com.library.kodillalibrary.model.reader;

import com.library.kodillalibrary.model.borrowed.Borowed;
import com.library.kodillalibrary.model.dao.ReaderDao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReaderMapper {

    public Reader mapToReader(ReaderDto readerDto) {
        Reader reader = new Reader(readerDto.getName(), readerDto.getSurname(), readerDto.getDateCrerateAccount(), readerDto.getBorowedList());
        reader.setId((long) 0);
        return reader;
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        List<Reader> readers = readerList;
        List<ReaderDto> readerDtos = new ArrayList<>();

        for (Reader reader: readers) {
            ReaderDto readerDto = new ReaderDto();
            readerDto.setId(reader.getId());
            readerDto.setName(reader.getName());
            readerDto.setSurname(reader.getSurname());
            readerDto.setDateCrerateAccount(reader.getDateCrerateAccount());

            List<Borowed> readerList1 = reader.getBorowedList();

            List<String> copyBooksDtoList = new ArrayList<>();

            for (Borowed borowed : readerList1) {
                copyBooksDtoList.add(borowed.getCopyBooks().getTitle().getTitleName() + ": beging borrowed " + borowed.getBeginBorrow() + "; end borrowed: " + borowed.getEndBorrow() + ";");
            }

            readerDto.setCopyBooksList(copyBooksDtoList);
            readerDtos.add(readerDto);
        }
        return readerDtos;
    }
}
