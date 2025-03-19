package org.example._18_mony_visa_spring_homework002.Models.DTO.Respones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private LocalDateTime time;
}
