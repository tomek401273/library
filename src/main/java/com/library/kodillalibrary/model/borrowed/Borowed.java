package com.library.kodillalibrary.model.borrowed;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.reader.Reader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOROWED")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Borowed {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;
    @Column
    private String beginBorrow;
    @Column
    private String endBorrow;
    @OneToOne
    @JoinColumn(name = "COPYBOOKS_ID",unique = true)
    private CopyBooks copyBooks;
    @ManyToOne
    @JoinColumn(name = "READER_ID")
    private Reader reader;

    public Borowed(String beginBorrow, String endBorrow) {
        this.beginBorrow = beginBorrow;
        this.endBorrow = endBorrow;
    }

    public Borowed(String beginBorrow, String endBorrow, CopyBooks copyBooks, Reader reader) {
        this.beginBorrow = beginBorrow;
        this.endBorrow = endBorrow;
        this.copyBooks = copyBooks;
        this.reader = reader;
    }
}
