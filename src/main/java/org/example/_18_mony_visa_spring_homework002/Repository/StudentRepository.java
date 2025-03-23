package org.example._18_mony_visa_spring_homework002.Repository;

import org.apache.ibatis.annotations.*;
import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.StudentRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Students;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("""
        SELECT s.student_id,s.student_name, s.email, s.phone_number,sc.course_id 
        FROM student_course as sc 
        INNER JOIN courses as c ON sc.course_id = c.course_id
        INNER JOIN students as s ON sc.student_id = s.student_id
        LIMIT #{limit}
        OFFSET #{offset}
        ;
    """)
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "course_id",
                    many = @Many(select = "org.example._18_mony_visa_spring_homework002.Repository.CourseRepository.getCourseById")),
    })
    List<Students> getStudent(Integer limit, Integer offset);

    @Select("""
        SELECT s.student_id,s.student_name, s.email, s.phone_number,sc.course_id FROM student_course as sc INNER JOIN courses as c ON sc.course_id = c.course_id
        INNER JOIN students as s ON sc.student_id = s.student_id
        WHERE s.student_id = #{id}
        ;
    """)
    @ResultMap("studentMapper")
    Students findstudentById(Integer id);

    @Insert("""
        DELETE FROM students WHERE student_id = #{id};
    """)
    @ResultMap("studentMapper")
    Students deleteStudent(Integer id);

    @Select("""
        INSERT INTO students(student_id,student_name,email,phone_number)
        VALUES(default,#{request.studentName},#{request.email},#{request.phoneNumber});
    """)
    @ResultMap("studentMapper")
    Students addStudent(@Param("request") StudentRequest students);

    @Insert("""
        INSERT INTO student_course VALUES(default,#{request.studentId},#{request.coursesId});
    """)
    @ResultMap("studentMapper")
    Students addStudentCourse(@Param("request") StudentRequest studentRequest);

    @Select("""
        UPDATE students SET student_name=#{request.studentName}, email=#{request.email}, phone_number=#{request.phoneNumber}
        WHERE student_id=#{request.studentId}
        RETURNING *;
    """)
    Students update(Integer updateStudent,@Param("request") StudentRequest students);
}
