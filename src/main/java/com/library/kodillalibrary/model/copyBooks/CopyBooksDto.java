package com.library.kodillalibrary.model.copyBooks;

import com.library.kodillalibrary.model.title.Title;

public class CopyBooksDto {
    private Long id;
    private String status;
    private Title title;
    private String titleName;
    private Long titleId;

    public CopyBooksDto() {
    }

    public CopyBooksDto(Long id, String status, String titleName, Long titleId) {
        this.id = id;
        this.status = status;
        this.titleName = titleName;
        this.titleId = titleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    @Override
    public String toString() {
        return "CopyBooksDto{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", title=" + title +
                ", titleName='" + titleName + '\'' +
                ", titleId=" + titleId +
                '}';
    }
}

