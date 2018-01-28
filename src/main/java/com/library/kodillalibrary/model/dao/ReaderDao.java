package com.library.kodillalibrary.model.dao;

import com.library.kodillalibrary.model.reader.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReaderDao extends CrudRepository<Reader, Long> {
    @Override
    List<Reader> findAll();
}
