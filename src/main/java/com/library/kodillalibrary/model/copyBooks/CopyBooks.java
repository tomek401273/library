package com.library.kodillalibrary.model.copyBooks;

import com.library.kodillalibrary.model.title.Title;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "COPYBOOKS")
public final class CopyBooks {

    private Long id;
    private String status;
    private Title title;
    public CopyBooks() {
    }

    public CopyBooks(String status) {
        this.status = status;
    }

    public CopyBooks(String status, Title title) {
        this.status = status;
        this.title = title;
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

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CopyBooks{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
