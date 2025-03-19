package org.example._18_mony_visa_spring_homework002.Services;

import org.apache.ibatis.annotations.Param;
import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.InstructorRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAll(Integer limit, Integer offset);
    Instructor insertRow(InstructorRequest instructorRequest);
    Instructor getById(Integer instructor_id);
    Instructor delInstructor(Integer instructor_id);
    Instructor upInstructor(Integer instructor_id, InstructorRequest instructorRequest);
}
