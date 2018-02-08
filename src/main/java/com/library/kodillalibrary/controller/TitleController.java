package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.model.copyBooks.CopyBooks;
import com.library.kodillalibrary.model.copyBooks.CopyBooksDto;
import com.library.kodillalibrary.model.copyBooks.CopyBooksMapper;
import com.library.kodillalibrary.model.borrowed.BorowedDto;
import com.library.kodillalibrary.model.borrowed.BorowedMapper;
import com.library.kodillalibrary.model.reader.ReaderDto;
import com.library.kodillalibrary.model.reader.ReaderMapper;
import com.library.kodillalibrary.model.dao.BorowedDao;
import com.library.kodillalibrary.model.dao.CopyBooksDao;
import com.library.kodillalibrary.model.dao.ReaderDao;
import com.library.kodillalibrary.model.dao.TitleDao;
import com.library.kodillalibrary.model.title.Title;
import com.library.kodillalibrary.model.title.TitleDto;
import com.library.kodillalibrary.model.title.TitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/title")
@CrossOrigin("*")
public class TitleController {

    @Autowired
    TitleDao titleDao;

    @Autowired
    private TitleMapper titleMapper;

    @RequestMapping("/all")
    public @ResponseBody
    List<TitleDto> getTitle() {
        return titleMapper.mapToTitleDtoList(titleDao.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", consumes = APPLICATION_JSON_VALUE)
    public void createNewTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);

        List<TitleDto> foundTitles = titleMapper.mapToTitleDtoList(titleDao.findByTitleNameAndAuthorAndPublicationYear(title.getTitleName(),title.getAuthor(),title.getPublicationYear()));


        if (foundTitles.size()==0) {
            System.out.println("Adding title to library!!!");
            titleDao.save(title);
        }
        else {
            System.out.println("This title is alredy added in our library");
        }

    }
}
