package com.library.kodillalibrary.model.borrowed;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.reader.Reader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
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

}
