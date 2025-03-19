package org.example._18_mony_visa_spring_homework002.Services.impl;

import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.InstructorRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Instructor;
import org.example._18_mony_visa_spring_homework002.Repository.InstructorRepository;
import org.example._18_mony_visa_spring_homework002.Services.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceimpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceimpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAll(Integer limit, Integer offset) {
        return instructorRepository.getall(limit, offset);
    }

    @Override
    public Instructor insertRow(InstructorRequest instructorRequest) {
        return instructorRepository.insertRow(instructorRequest);
    }

    @Override
    public Instructor getById(Integer instructor_id) {
        return instructorRepository.getbyId(instructor_id);
    }

    @Override
    public Instructor delInstructor(Integer instructor_id) {
        return instructorRepository.delInstructor(instructor_id);
    }

    @Override
    public Instructor upInstructor(Integer instructor_id, InstructorRequest instructorRequest) {
        return instructorRepository.upInstructor(instructor_id, instructorRequest);
    }
}
