package com.library.kodillalibrary.model.copyBooks;

import com.library.kodillalibrary.model.title.Title;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CopyBooksDto {
    private Long id;
    private String status;
    private Title title;
    private String titleName;
    private Long titleId;

    public CopyBooksDto(Long id, String status, String titleName, Long titleId) {
        this.id = id;
        this.status = status;
        this.titleName = titleName;
        this.titleId = titleId;
    }
}

