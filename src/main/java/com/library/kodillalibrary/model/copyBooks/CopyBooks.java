package com.library.kodillalibrary.model.copyBooks;

import com.library.kodillalibrary.model.title.Title;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COPYBOOKS")
@NoArgsConstructor
@Getter
@Setter
@ToString
public final class CopyBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    public CopyBooks(String status) {
        this.status = status;
    }

    public CopyBooks(String status, Title title) {
        this.status = status;
        this.title = title;
    }

}
