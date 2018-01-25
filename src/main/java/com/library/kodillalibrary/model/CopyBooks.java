package com.library.kodillalibrary.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "COPYBOOKS")
public final class CopyBooks {


    private Long id;
    private String status;
//    private Title title;

    public CopyBooks(String status) {
        this.status = status;
    }

    public CopyBooks() {
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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @ManyToOne
////    @JoinColumn(name = "TITLE_ID")
//    public Title getTitle() {
//        return title;
//    }

//    public void setTitle(Title title) {
//        this.title = title;
//    }

    @Override
    public String toString() {
        return "CopyBooks{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
