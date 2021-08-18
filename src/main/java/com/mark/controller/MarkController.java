package com.mark.controller;

import com.feign.dto.MarkDTO;
import com.mark.model.Mark;
import com.mark.repository.MarkRepository;
import com.mark.service.MarkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student/mark")
@RestController
public class MarkController {

    Logger logger= LoggerFactory.getLogger(MarkController.class);

    private MarkRepository markRepository;

    @Autowired
    public void setMarkRepository(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    private MarkService markService;

    @Autowired
    public void setMarkService(MarkService markService) {
        this.markService = markService;
    }

    @PostMapping("/add-mark")
    public MarkDTO addMark(@RequestBody MarkDTO markDTO){


        return  markService.addMark(markDTO);
    }

    //to get all the marks with student id
    @GetMapping("/getAllMarks")
    public List<Mark> getAllMarks(){
        return  markRepository.findAll();
    }


    @GetMapping("/get-mark/{studentId}")
    public List<MarkDTO> getMarks(@PathVariable("studentId") int studentId){

        List<MarkDTO> markDTO=markService.getMark(studentId);

        markDTO.forEach(System.out::println);

        return markDTO;
    }

}
