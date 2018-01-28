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
        System.out.println("title TITLE: "+title);
        List<CopyBooksDto> copyBooksDtos = copyBooksMapper.mapToCopyDtoList(copyBooksDao.findAll());
        List<CopyBooksDto> copyBooksDtos2 = new ArrayList<>();

        for (CopyBooksDto copyBooksDto : copyBooksDtos) {

            if (copyBooksDto.getStatus().equals("FREE")) {
                if (copyBooksDto.getTitleName().equals(title)){
                    copyBooksDtos2.add(copyBooksDto);
                    System.out.println(copyBooksDto.getTitleName());

                }
            }
        }
        return copyBooksDtos2;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", consumes = APPLICATION_JSON_VALUE)
    public void createCopyBooks(@RequestBody CopyBooksDto copyBooksDto) {
        CopyBooks copyBooks = copyBooksMapper.mapToCopyBooks(copyBooksDto);
        copyBooksDao.save(copyBooks);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public void updateTask(@RequestBody CopyBooksDto copyBooksDto) {
        CopyBooks copyBooks = copyBooksMapper.mapToCopyBooksUpdate(copyBooksDto);
        copyBooksDao.save(copyBooks);

    }

}
