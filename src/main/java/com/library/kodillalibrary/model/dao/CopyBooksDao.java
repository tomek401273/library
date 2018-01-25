package com.library.kodillalibrary.model.dao;

import com.library.kodillalibrary.model.CopyBooks;
import com.library.kodillalibrary.model.Title;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CopyBooksDao extends CrudRepository<CopyBooks, Long>{
    @Override
    List<CopyBooks> findAll();
}
