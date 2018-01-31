package com.library.kodillalibrary.model.title;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TITLE")
public class Title {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private long id;

    @Column(name = "TITLENAME")
    private String titleName;
    @Column
    private String author;
    @Column
    private int publicationYear;

    @OneToMany(
            targetEntity = CopyBooks.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CopyBooks> copyBooksList = new ArrayList<>();

    public Title(String titleName, String author, int publicationYear, List<CopyBooks> copyBooksList) {
        this.titleName = titleName;
        this.author = author;
        this.publicationYear = publicationYear;
        this.copyBooksList = copyBooksList;
    }
}
