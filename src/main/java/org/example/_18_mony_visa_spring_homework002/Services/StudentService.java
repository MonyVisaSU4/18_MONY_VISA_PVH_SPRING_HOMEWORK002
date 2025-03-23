package org.example._18_mony_visa_spring_homework002.Services;

import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.StudentRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Students;

import java.util.List;

public interface StudentService {
    List<Students> getStudent(Integer limit, Integer offset);
    Students findstudentById(Integer id);
    Students deleteStudent(Integer id);
    Students addStudent(StudentRequest studentRequest);
    Students updateStudent(Integer updateStudent, StudentRequest students);
}
