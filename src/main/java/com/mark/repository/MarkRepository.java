package com.mark.repository;

import com.mark.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarkRepository extends JpaRepository <Mark,Integer> {

//    @Query("select m from Mark m where m.studentId=:studentId ")
//    List<Mark> getByUserId(int studentId);

    List<Mark> findByStudentId(int studentId);

}
