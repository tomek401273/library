package com.library.kodillalibrary.model.dao;

import com.library.kodillalibrary.model.borrowed.Borowed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorowedDao extends CrudRepository<Borowed, Long> {

    @Override
    List<Borowed> findAll();

    Borowed findById(Long id);
}
