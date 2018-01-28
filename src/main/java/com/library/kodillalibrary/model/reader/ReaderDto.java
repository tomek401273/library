package com.library.kodillalibrary.model.reader;

import com.library.kodillalibrary.model.borrowed.Borowed;

import java.util.ArrayList;
import java.util.List;

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

    public ReaderDto() {
    }

    public ReaderDto(Long id, String name, String surname, String dateCrerateAccount, List<Borowed> borowedList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateCrerateAccount = dateCrerateAccount;
        this.borowedList = borowedList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDateCrerateAccount() {
        return dateCrerateAccount;
    }

    public void setDateCrerateAccount(String dateCrerateAccount) {
        this.dateCrerateAccount = dateCrerateAccount;
    }

    public List<Borowed> getBorowedList() {
        return borowedList;
    }

    public void setBorowedList(List<Borowed> borowedList) {
        this.borowedList = borowedList;
    }

    public List<String> getCopyBooksList() {
        return copyBooksList;
    }

    public void setCopyBooksList(List<String> copyBooksList) {
        this.copyBooksList = copyBooksList;
    }

    @Override
    public String toString() {
        return "ReaderDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateCrerateAccount='" + dateCrerateAccount + '\'' +
                ", borowedList=" + borowedList +
                '}';
    }
}
