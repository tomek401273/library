package com.library.kodillalibrary.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TITLE")
public class Title {

    private long id;
    private String titleName;
    private String author;
    private int publicationYear;
    private List<CopyBooks> copyBooksList = new ArrayList<>();

    public Title() {
    }

    public Title(String titleName, String author, int publicationYear, List<CopyBooks> copyBooksList) {
        this.titleName = titleName;
        this.author = author;
        this.publicationYear = publicationYear;
        this.copyBooksList = copyBooksList;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "TITLENAME")
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Column()
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Column()
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    @OneToMany(
            targetEntity = CopyBooks.class
          //  mappedBy = "title"
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
    )
    public List<CopyBooks> getCopyBooksList() {
        return copyBooksList;
    }

    public void setCopyBooksList(List<CopyBooks> copyBooksList) {
        this.copyBooksList = copyBooksList;
    }
}
