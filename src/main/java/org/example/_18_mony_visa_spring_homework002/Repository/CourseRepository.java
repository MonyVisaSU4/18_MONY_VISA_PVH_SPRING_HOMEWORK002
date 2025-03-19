package org.example._18_mony_visa_spring_homework002.Repository;

import org.apache.ibatis.annotations.*;
import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.CourseRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Select("""
        SELECT * FROM courses LIMIT #{limit} OFFSET #{offset};
    """)
    @Results(id = "courseMapper", value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "name", column = "course_name"),
            @Result(property = "desc", column = "description"),
            @Result(property = "instructor", column = "instuctor_id", one = @One(select = "org.example._18_mony_visa_spring_homework002.Repository.InstructorRepository.getbyId"))
    })
    List<Course> getAll(Integer limit, Integer offset);

    @Select("""
        INSERT INTO courses (course_name, description, instuctor_id) VALUES
        (#{reques.name}, #{reques.desc}, #{reques.instructId})
        RETURNING *;
    """)
    @ResultMap("courseMapper")
    Course insertCourse(@Param("reques") CourseRequest courseRequest);

    @Select("""
        SELECT * FROM courses WHERE course_id = #{findId}
    """)
    @ResultMap("courseMapper")
    Course getCourseById(Integer findId);

    @Select("""
        DELETE FROM courses WHERE course_id = #{delId}
        RETURNING *
    """)
    @ResultMap("courseMapper")
    Course delelteCourse(Integer delId);

    @Select("""
        UPDATE courses SET course_name = #{request.name}, description = #{request.desc}, instuctor_id = #{request.instructId}
        WHERE course_id = #{upId}
        RETURNING *;
    """)
    @ResultMap("courseMapper")
    Course upCourse(Integer upId, @Param("request") CourseRequest courseRequest);
}
