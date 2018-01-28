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
    public void crateNewBorow(@RequestBody BorowedDto borowedDto) {

        System.out.println("Borowed Dto: " + borowedDto.toString());
        Borowed borowed = borowedMapper.mapToBorowed(borowedDto);
        System.out.println("Borowed: " + borowed.toString());


        CopyBooks copyBooks = copyBooksDao.findById(borowed.getCopyBooks().getId());

        copyBooks.setStatus("Phone");
        copyBooksDao.save(copyBooks);

//        borowed.setCopyBooks(copyBooks);
//        copyBookController.updateTask2(borowed.getCopyBooks());

        borowedDao.save(borowed);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteBorow(@PathVariable(value = "id") Long id) {
        List<Borowed> borowedDtoList = borowedDao.findAll();

        for (int i = 0; i < borowedDtoList.size(); i++) {
            Borowed borowed = borowedDtoList.get(i);
            if (borowed.getCopyBooks().getId().equals(id)) {

                CopyBooks copyBooks = copyBooksDao.findById(borowed.getCopyBooks().getId());
                copyBooks.setStatus("FREEEEE!!!");
                copyBooksDao.save(copyBooks);

                borowedDao.delete(borowed);
            }
        }
    }
}
