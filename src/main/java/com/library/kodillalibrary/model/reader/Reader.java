package com.library.kodillalibrary.model.reader;

import com.library.kodillalibrary.model.borrowed.Borowed;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "READER")
public class Reader {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String dateCrerateAccount;

    @OneToMany(
            targetEntity = Borowed.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Borowed> borowedList = new ArrayList<>();

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

}
