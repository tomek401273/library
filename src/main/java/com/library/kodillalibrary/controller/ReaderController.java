package com.library.kodillalibrary.controller;

import com.library.kodillalibrary.model.dao.ReaderDao;
import com.library.kodillalibrary.model.reader.Reader;
import com.library.kodillalibrary.model.reader.ReaderDto;
import com.library.kodillalibrary.model.reader.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/reader")
@CrossOrigin("*")
public class ReaderController {
    @Autowired
    private ReaderMapper readerMapper;
    @Autowired
    private ReaderDao readerDao;

    @RequestMapping("/all")
    public @ResponseBody
    List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(readerDao.findAll());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save",consumes = APPLICATION_JSON_VALUE)
    public String createNewReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        readerDao.save(reader);
        return "Registration process was successfully";
    }
}
