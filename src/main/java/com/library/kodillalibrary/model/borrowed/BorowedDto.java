package com.library.kodillalibrary.model.borrowed;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.reader.Reader;

public class BorowedDto {
    private Long id;
    private String beginBorrow;
    private String endBorrow;
    private CopyBooks copyBooks;
    private Reader reader;
    private String readerName;
    private String coopyBooksPosition;
    private Long rederId;
    private Long copyBooksId;

    public BorowedDto() {
    }

    public BorowedDto(Long id, String beginBorrow, String endBorrow) {
        this.id = id;
        this.beginBorrow = beginBorrow;
        this.endBorrow = endBorrow;
    }

    public BorowedDto(String beginBorrow, String endBorrow, Long rederId, Long copyBooksId) {
        this.beginBorrow = beginBorrow;
        this.endBorrow = endBorrow;
        this.rederId = rederId;
        this.copyBooksId = copyBooksId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeginBorrow() {
        return beginBorrow;
    }

    public void setBeginBorrow(String beginBorrow) {
        this.beginBorrow = beginBorrow;
    }

    public String getEndBorrow() {
        return endBorrow;
    }

    public void setEndBorrow(String endBorrow) {
        this.endBorrow = endBorrow;
    }

    public CopyBooks getCopyBooks() {
        return copyBooks;
    }

    public void setCopyBooks(CopyBooks copyBooks) {
        this.copyBooks = copyBooks;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getCoopyBooksPosition() {
        return coopyBooksPosition;
    }

    public void setCoopyBooksPosition(String coopyBooksPosition) {
        this.coopyBooksPosition = coopyBooksPosition;
    }

    public Long getRederId() {
        return rederId;
    }

    public void setRederId(Long rederId) {
        this.rederId = rederId;
    }

    public Long getCopyBooksId() {
        return copyBooksId;
    }

    public void setCopyBooksId(Long copyBooksId) {
        this.copyBooksId = copyBooksId;
    }

    @Override
    public String toString() {
        return "BorowedDto{" +
                "id=" + id +
                ", beginBorrow='" + beginBorrow + '\'' +
                ", endBorrow='" + endBorrow + '\'' +
                ", copyBooks=" + copyBooks +
                ", reader=" + reader +
                ", readerName='" + readerName + '\'' +
                ", coopyBooksPosition='" + coopyBooksPosition + '\'' +
                ", rederId=" + rederId +
                ", copyBooksId=" + copyBooksId +
                '}';
    }
}
