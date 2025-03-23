package org.example._18_mony_visa_spring_homework002.Controllers;

import org.example._18_mony_visa_spring_homework002.Models.DTO.Respones.ApiResponse;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Students;
import org.example._18_mony_visa_spring_homework002.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/show")
    public ResponseEntity<ApiResponse<List<Students>>> showallStudent(@RequestParam(defaultValue = "5") Integer limit, @RequestParam(defaultValue = "0") Integer offset){
        ApiResponse<List<Students>> apiResponse = ApiResponse.<List<Students>>builder()
                .message("All courses have been successfully fetched.")
                .payload(studentService.getStudent(limit, offset))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{search}")
    public ResponseEntity<ApiResponse<Students>> searchStudent(@RequestParam Integer search){
        ApiResponse<Students> apiResponse = ApiResponse.<Students>builder()
                .message("All courses have been successfully fetched.")
                .payload(studentService.findstudentById(search))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{delete}")
    public ResponseEntity<ApiResponse<Students>> delStudent(@RequestParam Integer delete){
        ApiResponse<Students> apiResponse = ApiResponse.<Students>builder()
                .message("All courses have been successfully fetched.")
                .payload(studentService.deleteStudent(delete))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<ApiResponse<Students>> addStudent(@RequestBody Students students){
        ApiResponse<Students> apiResponse = ApiResponse.<Students>builder()
                .message("All courses have been successfully fetched.")
                .payload(studentService.addStudent(students))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{updateStudent}")
    public ResponseEntity<ApiResponse<Students>> updateStudent(@RequestParam Integer updateStudent, @RequestBody Students students){
        ApiResponse<Students> apiResponse = ApiResponse.<Students>builder()
                .message("All courses have been successfully fetched.")
                .payload(studentService.updateStudent(updateStudent, students))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }
}
