package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.copyBooks.CopyBooksDto;
import com.library.kodillalibrary.model.copyBooks.CopyBooksMapper;
import com.library.kodillalibrary.model.dao.CopyBooksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/copyBooks")
@CrossOrigin("*")
public class CopyBookController {
    @Autowired
    CopyBooksDao copyBooksDao;
    @Autowired
    private CopyBooksMapper copyBooksMapper;

    @RequestMapping("/all")
    public @ResponseBody
    List<CopyBooksDto> getCopyBooks() {
        //return copyBooksDao.findAll();
        return copyBooksMapper.mapToCopyDtoList(copyBooksDao.findAll());
    }

    @RequestMapping("/free/{title}")
    public @ResponseBody
    List<CopyBooksDto> getCopyBooks2(@PathVariable(value = "title") String title) {
        return copyBooksMapper.mapToCopyDtoList(copyBooksDao.findByTitle_TitleNameAndStatus(title, "FREE"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", consumes = APPLICATION_JSON_VALUE)
    public String createCopyBooks(@RequestBody CopyBooksDto copyBooksDto) {
        CopyBooks copyBooks = copyBooksMapper.mapToCopyBooks(copyBooksDto);
        copyBooksDao.save(copyBooks);
        return "Saving in database ending successfully";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public String updateCopyBookStatus(@RequestBody CopyBooksDto copyBooksDto) {
        CopyBooks copyBooks = copyBooksMapper.mapToCopyBooksUpdate(copyBooksDto);
        copyBooksDao.save(copyBooks);
        return "Updating CoppyBook ending succesfuly";
    }

}
