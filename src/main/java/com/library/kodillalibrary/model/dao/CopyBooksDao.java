package com.library.kodillalibrary.model.dao;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CopyBooksDao extends CrudRepository<CopyBooks, Long>{
    @Override
    List<CopyBooks> findAll();

    CopyBooks findById(Long id);
}
