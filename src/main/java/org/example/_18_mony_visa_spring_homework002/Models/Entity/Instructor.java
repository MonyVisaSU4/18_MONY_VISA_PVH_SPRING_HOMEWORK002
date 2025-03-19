package org.example._18_mony_visa_spring_homework002.Models.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    private Integer instructor_id;
    private String instructor_name;
    private String email;
}
