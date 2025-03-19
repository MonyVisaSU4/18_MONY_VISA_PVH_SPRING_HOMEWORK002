package org.example._18_mony_visa_spring_homework002.Services;

import org.apache.ibatis.annotations.Param;
import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.CourseRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Course;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CourseService {
    List<Course> getAll(Integer limit, Integer offset);
    Course insertCourse(CourseRequest courseRequest);
    Course getCourseById(Integer findId);
    Course delelteCourse(Integer delId);
    Course upCourse(Integer upId, CourseRequest courseRequest);
}
