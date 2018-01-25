package com.library.kodillalibrary.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "BORROWED")
public class Borrowed {
    private Long id;
    private String beginBorrow;
    private String endBorrow;
    private CopyBooks copyBooks;
    private Reader reader;

    public Borrowed() {
    }

    public Borrowed(String beginBorrow, String endBorrow) {
        this.beginBorrow = beginBorrow;
        this.endBorrow = endBorrow;
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
    @JoinColumn(name = "COPYBOOKS_ID")
    public CopyBooks getCopyBooks() {
        return copyBooks;
    }

    public void setCopyBooks(CopyBooks copyBooks) {
        this.copyBooks = copyBooks;
    }

    @OneToOne
    @JoinColumn(name = "READER_ID")
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
