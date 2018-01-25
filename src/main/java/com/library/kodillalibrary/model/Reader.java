package com.library.kodillalibrary.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "READER")
public class Reader {
    private Long id;
    private String name;
    private String surname;
    private String dateCrerateAccount;

    public Reader() {
    }


    public Reader(String name, String surname, String dateCrerateAccount) {
        this.name = name;
        this.surname = surname;
        this.dateCrerateAccount = dateCrerateAccount;
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
}
