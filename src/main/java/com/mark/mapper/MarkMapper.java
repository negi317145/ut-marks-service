package com.mark.mapper;


import com.feign.dto.MarkDTO;
import com.mark.model.Mark;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MarkMapper {

    Logger logger= LoggerFactory.getLogger(MarkMapper.class);


    public Mark DTOToEntity(MarkDTO markDTO){

        Mark mark=new Mark();
        mark.setMarkId(markDTO.getMarkId());
        mark.setSubject(markDTO.getSubject());
        mark.setMark(markDTO.getMark());
        mark.setStudentId(markDTO.getStudentId());
        return mark;
    }

   public MarkDTO entityToDTO(Mark mark){

        MarkDTO markDTO=new MarkDTO();
        markDTO.setMarkId(mark.getMarkId());
        markDTO.setSubject(mark.getSubject());
        markDTO.setMark(mark.getMark());
        markDTO.setStudentId(mark.getStudentId());

        return markDTO;
    }


   public List<MarkDTO> entityToDTO(List<Mark> mark){


        mark.forEach(System.out::println);

        return mark.stream().map(m -> entityToDTO(m)).collect(Collectors.toList());
    }


}
