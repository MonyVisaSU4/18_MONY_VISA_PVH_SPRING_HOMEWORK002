package org.example._18_mony_visa_spring_homework002.Services.impl;

import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.CourseRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Course;
import org.example._18_mony_visa_spring_homework002.Repository.CourseRepository;
import org.example._18_mony_visa_spring_homework002.Services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceimpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAll(Integer limit, Integer offset) {
        return courseRepository.getAll(limit, offset);
    }

    @Override
    public Course insertCourse(CourseRequest courseRequest) {
        return courseRepository.insertCourse(courseRequest);
    }

    @Override
    public Course getCourseById(Integer findId) {
        return courseRepository.getCourseById(findId);
    }

    @Override
    public Course delelteCourse(Integer delId) {
        return courseRepository.delelteCourse(delId);
    }

    @Override
    public Course upCourse(Integer upId, CourseRequest courseRequest) {
        return courseRepository.upCourse(upId,courseRequest);
    }
}
