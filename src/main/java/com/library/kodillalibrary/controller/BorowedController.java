package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.model.borrowed.Borowed;
import com.library.kodillalibrary.model.borrowed.BorowedDto;
import com.library.kodillalibrary.model.borrowed.BorowedMapper;
import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.dao.BorowedDao;
import com.library.kodillalibrary.model.dao.CopyBooksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/borowed")
public class BorowedController {
    @Autowired
    private BorowedDao borowedDao;

    @Autowired
    private BorowedMapper borowedMapper;

    @Autowired
    CopyBookController copyBookController;

    @Autowired
    CopyBooksDao copyBooksDao;

    @RequestMapping("/all")
    public @ResponseBody
    List<BorowedDto> getBorrowed() {
        return borowedMapper.mapToDtoList(borowedDao.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", consumes = APPLICATION_JSON_VALUE)
    public String crateNewBorow(@RequestBody BorowedDto borowedDto) {
        Borowed borowed = borowedMapper.mapToBorowed(borowedDto);
        CopyBooks copyBooks = copyBooksDao.findById(borowed.getCopyBooks().getId());
        if (copyBooks.getStatus().equals("Free")) {

            copyBooks.setStatus("Borrowed");
            copyBooksDao.save(copyBooks);
            borowedDao.save(borowed);
            return "You just borrowed book";
        }
        return "This book is occupied";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public String deleteBorow(@PathVariable(value = "id") Long id) {
        Borowed borowed = borowedDao.findById(id);
        try {
            CopyBooks copyBooks = copyBooksDao.findById(borowed.getCopyBooks().getId());
            copyBooks.setStatus("Free");
            copyBooksDao.save(copyBooks);
            borowedDao.delete(borowed);
            return "Deleting books ending succesfully";
        } catch (NullPointerException e) {
            return "This borrowed NOT exit in database";
        }
    }
}
