package com.library.kodillalibrary.model.borrowed;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.reader.Reader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BOROWED")
public class Borowed {
    private Long id;
    private String beginBorrow;
    private String endBorrow;
    private CopyBooks copyBooks;
    private Reader reader;

    public Borowed() {
    }

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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getBeginBorrow() {
        return beginBorrow;
    }

    public void setBeginBorrow(String beginBorrow) {
        this.beginBorrow = beginBorrow;
    }

    @Column
    public String getEndBorrow() {
        return endBorrow;
    }

    public void setEndBorrow(String endBorrow) {
        this.endBorrow = endBorrow;
    }

    @OneToOne
    @JoinColumn(name = "COPYBOOKS_ID",unique = true)
    public CopyBooks getCopyBooks() {
        return copyBooks;
    }

    public void setCopyBooks(CopyBooks copyBooks) {
        this.copyBooks = copyBooks;
    }

    @ManyToOne
    @JoinColumn(name = "READER_ID")
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Borowed{" +
                "id=" + id +
                ", beginBorrow='" + beginBorrow + '\'' +
                ", endBorrow='" + endBorrow + '\'' +
                ", copyBooks=" + copyBooks +
                ", reader=" + reader +
                '}';
    }
}
