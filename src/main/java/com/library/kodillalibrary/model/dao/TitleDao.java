package com.library.kodillalibrary.model.dao;

import com.library.kodillalibrary.model.title.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitleDao extends CrudRepository<Title, Long> {
    @Override
    List<Title> findAll();

    List<Title> findByTitleNameAndAuthorAndPublicationYear(String titleName, String author, int publicationYear);

}
