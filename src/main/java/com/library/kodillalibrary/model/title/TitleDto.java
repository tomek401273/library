package com.library.kodillalibrary.model.title;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;

import java.util.ArrayList;
import java.util.List;

public class TitleDto {
    private long id;
    private String titleName;
    private String author;
    private int publicationYear;

    private List<CopyBooks> copyBooksList = new ArrayList<>();
    private List<String> statusList = new ArrayList<>();

    public TitleDto() {
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public List<CopyBooks> getCopyBooksList() {
        return copyBooksList;
    }

    public void setCopyBooksList(List<CopyBooks> copyBooksList) {
        this.copyBooksList = copyBooksList;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }


}
