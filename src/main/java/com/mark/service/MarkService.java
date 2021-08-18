package com.mark.service;

import com.feign.dto.MarkDTO;

import java.util.List;

public interface MarkService {


    MarkDTO addMark(MarkDTO markDTO);


    List<MarkDTO> getMark(int studentId);


}
