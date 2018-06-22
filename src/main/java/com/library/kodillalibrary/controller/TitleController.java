package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.model.dao.TitleDao;
import com.library.kodillalibrary.model.title.Title;
import com.library.kodillalibrary.model.title.TitleDto;
import com.library.kodillalibrary.model.title.TitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String createNewTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        List<TitleDto> foundTitles = titleMapper.mapToTitleDtoList(titleDao.findByTitleNameAndAuthorAndPublicationYear(title.getTitleName(), title.getAuthor(), title.getPublicationYear()));
        if (foundTitles.size() == 0) {
            titleDao.save(title);
            return "Processing added title to library was successful ";
        }
        return "This title already is in this library";
    }
}
