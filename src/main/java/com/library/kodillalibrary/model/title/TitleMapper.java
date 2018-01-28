package com.library.kodillalibrary.model.title;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.copyBooks.CopyBooksDto;
import com.library.kodillalibrary.model.copyBooks.CopyBooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TitleMapper {

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(titleDto.getTitleName(), titleDto.getAuthor(), titleDto.getPublicationYear(), titleDto.getCopyBooksList());
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {

        List<TitleDto> titleDtos = new ArrayList<>();

        for (Title title : titleList) {
            TitleDto titleDto1 = new TitleDto(title.getId(), title.getTitleName(), title.getAuthor(), title.getPublicationYear());
            List<String> statusList2 = new ArrayList<>();
            List<CopyBooks> copyBooksList = new ArrayList<>();

            for (CopyBooks copyBooks : title.getCopyBooksList()) {
                statusList2.add("id: " + copyBooks.getId() + " status:" + copyBooks.getStatus());
                CopyBooks copyBooks2 = new CopyBooks();
                copyBooks2.setId(copyBooks.getId());
                copyBooks2.setStatus(copyBooks.getStatus());
                copyBooksList.add(copyBooks2);
            }

            titleDto1.setStatusList(statusList2);
            titleDto1.setCopyBooksList(copyBooksList);
            titleDtos.add(titleDto1);
        }
        return titleDtos;
    }
}
