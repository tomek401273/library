package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.model.CopyBooks;
import com.library.kodillalibrary.model.Title;
import com.library.kodillalibrary.model.dao.CopyBooksDao;
import com.library.kodillalibrary.model.dao.TitleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/title")
@CrossOrigin("*")
public class TitleController {

    @Autowired
    TitleDao titleDao;
    @Autowired
    CopyBooksDao copyBooksDao;

    @RequestMapping("/all")
    public @ResponseBody
    List<Title> getTitle () {
        return titleDao.findAll();
    }

    @RequestMapping("/all2")
    public @ResponseBody
    List<CopyBooks> getCopyBooks() {
        return copyBooksDao.findAll();
    }

}
