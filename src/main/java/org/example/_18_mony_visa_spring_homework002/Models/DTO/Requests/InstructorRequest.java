package org.example._18_mony_visa_spring_homework002.Models.DTO.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorRequest {
    private String instructor_name;
    private String email;
}
