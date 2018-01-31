package com.library.kodillalibrary.model.reader;

import com.library.kodillalibrary.model.borrowed.Borowed;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReaderDto {
    private Long id;
    private String name;
    private String surname;
    private String dateCrerateAccount;
    private List<Borowed> borowedList = new ArrayList<>();
    private List<String> copyBooksList = new ArrayList<>();

    public ReaderDto(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public ReaderDto(Long id, String name, String surname, String dateCrerateAccount, List<Borowed> borowedList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateCrerateAccount = dateCrerateAccount;
        this.borowedList = borowedList;
    }
}
