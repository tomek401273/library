package com.library.kodillalibrary.model.title;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TitleDto {
    private long id;
    private String titleName;
    private String author;
    private int publicationYear;
    private List<CopyBooks> copyBooksList = new ArrayList<>();
    private List<String> statusList = new ArrayList<>();

    public TitleDto(long id, String titleName, String author, int publicationYear) {
        this.id = id;
        this.titleName = titleName;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public TitleDto(long id, String titleName, String author, int publicationYear, List<String> statusList) {
        this.id = id;
        this.titleName = titleName;
        this.author = author;
        this.publicationYear = publicationYear;
        this.statusList = statusList;
    }
}
