package org.example._18_mony_visa_spring_homework002.Models.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Integer id;
    private String name;
    private String desc;
    private Instructor instructor;
}
