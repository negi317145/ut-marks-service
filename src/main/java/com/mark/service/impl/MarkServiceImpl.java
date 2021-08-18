package com.mark.service.impl;

import com.feign.dto.MarkDTO;
import com.mark.mapper.MarkMapper;
import com.mark.model.Mark;
import com.mark.repository.MarkRepository;
import com.mark.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {

    private MarkMapper markMapper;

    @Autowired
    public void setMarkMapper(MarkMapper markMapper) {
        this.markMapper = markMapper;
    }


    private MarkRepository markRepository;

    @Autowired
    public void setMarkRepository(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @Override
    public MarkDTO addMark(MarkDTO markDTO) {

        Mark mark=new Mark();

        mark=markMapper.DTOToEntity(markDTO);
        mark=markRepository.save(mark);

        markDTO.setMarkId(mark.getMarkId());
        markDTO.setSubject(mark.getSubject());
        markDTO.setMark(mark.getMark());
        markDTO.setStudentId(mark.getStudentId());

        return markDTO;
    }

    @Override
    public List<MarkDTO> getMark(int studentId) {

        List<Mark> mark=markRepository.findByStudentId(studentId);

        return markMapper.entityToDTO(mark);

    }

}
