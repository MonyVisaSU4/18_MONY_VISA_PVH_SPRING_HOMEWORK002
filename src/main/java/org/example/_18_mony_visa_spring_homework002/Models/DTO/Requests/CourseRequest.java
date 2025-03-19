package org.example._18_mony_visa_spring_homework002.Models.DTO.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Instructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String name;
    private String desc;
    private Integer instructId;
}
