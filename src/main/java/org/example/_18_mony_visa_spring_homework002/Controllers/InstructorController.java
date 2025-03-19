package org.example._18_mony_visa_spring_homework002.Controllers;

import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.InstructorRequest;
import org.example._18_mony_visa_spring_homework002.Models.DTO.Respones.ApiResponse;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Instructor;
import org.example._18_mony_visa_spring_homework002.Services.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/shows")
    public ResponseEntity<ApiResponse<List<Instructor>>> getAll(@RequestParam(defaultValue = "5") Integer limit,@RequestParam(defaultValue = "0") Integer offset){
        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder()
                .message("All instructors have been successfully fetched.")
                .payload(instructorService.getAll(limit, offset))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/insert")
    public ResponseEntity<ApiResponse<Instructor>> insertRow(InstructorRequest instructorRequest){
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("All instructors have been successfully fetched.")
                .payload(instructorService.insertRow(instructorRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{getById}")
    public ResponseEntity<ApiResponse<Instructor>> getById(Integer getById){
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("All instructors have been successfully fetched.")
                .payload(instructorService.getById(getById))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{delById}")
    public ResponseEntity<ApiResponse<Instructor>> delInstrutor(Integer delById){
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("All instructors have been successfully fetched.")
                .payload(instructorService.delInstructor(delById))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{update}")
    public ResponseEntity<ApiResponse<Instructor>> upInstrutor(Integer update, InstructorRequest instructorRequest){
        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .message("All instructors have been successfully fetched.")
                .payload(instructorService.upInstructor(update,instructorRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(response);
    }
}
