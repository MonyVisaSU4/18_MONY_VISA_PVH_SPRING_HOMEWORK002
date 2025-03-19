package org.example._18_mony_visa_spring_homework002.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.InstructorRequest;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Instructor;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Select("""
        SELECT * FROM instructors LIMIT #{limit} OFFSET #{offset};
    """)
    List<Instructor> getall(Integer limit, Integer offset);

    @Select("""
        INSERT INTO instructors (instructor_name, email) VALUES
        (#{request.instructor_name}, #{request.email})
        RETURNING *;
    """)
    Instructor insertRow(@Param("request") InstructorRequest instructorRequest);

    @Select("""
        SELECT * FROM instructors WHERE instructor_id = #{instructor_id};
    """)
    Instructor getbyId(Integer instructor_id);

    @Select("""
        DELETE FROM instructors WHERE instructor_id = #{instructor_id}
        RETURNING *
    """)
    Instructor delInstructor(Integer instructor_id);

    @Select("""
        UPDATE instructors SET instructor_name=#{request.instructor_name}, email=#{request.email} WHERE instructor_id = #{instructor_id}
        RETURNING *;
    """)
    Instructor upInstructor(Integer instructor_id, @Param("request") InstructorRequest instructorRequest);
}
