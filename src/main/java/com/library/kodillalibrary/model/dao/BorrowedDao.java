package com.library.kodillalibrary.model.dao;

import com.library.kodillalibrary.model.Borrowed;
import org.springframework.data.repository.CrudRepository;

public interface BorrowedDao extends CrudRepository<Borrowed, Long> {
}
