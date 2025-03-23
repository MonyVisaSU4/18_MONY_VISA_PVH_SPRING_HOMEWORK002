package org.example._18_mony_visa_spring_homework002.Models.DTO.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Course;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Course> coursesId;
}
