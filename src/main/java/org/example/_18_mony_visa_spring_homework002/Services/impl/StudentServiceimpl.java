package org.example._18_mony_visa_spring_homework002.Services.impl;

import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.StudentRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Students;
import org.example._18_mony_visa_spring_homework002.Repository.StudentRepository;
import org.example._18_mony_visa_spring_homework002.Services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceimpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Students> getStudent(Integer limit, Integer offset) {
        return studentRepository.getStudent(limit, offset);
    }

    @Override
    public Students findstudentById(Integer id) {
        return studentRepository.findstudentById(id);
    }

    @Override
    public Students deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
        return studentRepository.findstudentById(id);
    }

    @Override
    public Students addStudent(StudentRequest studentRequest) {
        studentRepository.addStudent(studentRequest);
        studentRepository.addStudentCourse(studentRequest);
        return studentRepository.addStudent(studentRequest);
    }

    @Override
    public Students updateStudent(Integer updateStudent, StudentRequest students) {
        return studentRepository.update(updateStudent, students);
    }
}
