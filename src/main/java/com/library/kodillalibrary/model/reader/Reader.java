package com.library.kodillalibrary.model.reader;

import com.library.kodillalibrary.model.borrowed.Borowed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "READER")
public class Reader {
    private Long id;
    private String name;
    private String surname;
    private String dateCrerateAccount;
    private List<Borowed> borowedList = new ArrayList<>();

    public Reader() {
    }

    public Reader(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Reader(String name, String surname, String dateCrerateAccount, List<Borowed> borowedList) {
        this.name = name;
        this.surname = surname;
        this.dateCrerateAccount = dateCrerateAccount;
        this.borowedList = borowedList;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column
    public String getDateCrerateAccount() {
        return dateCrerateAccount;
    }

    public void setDateCrerateAccount(String dateCrerateAccount) {
        this.dateCrerateAccount = dateCrerateAccount;
    }

    @OneToMany(
            targetEntity = Borowed.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Borowed> getBorrowedList() {
        return borowedList;
    }

    public void setBorrowedList(List<Borowed> borowedList) {
        this.borowedList = borowedList;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateCrerateAccount='" + dateCrerateAccount + '\'' +
                ", borowedList=" + borowedList +
                '}';
    }
}
