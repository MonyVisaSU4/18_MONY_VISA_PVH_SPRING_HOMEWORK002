package org.example._18_mony_visa_spring_homework002.Controllers;

import org.example._18_mony_visa_spring_homework002.Models.DTO.Requests.CourseRequest;
import org.example._18_mony_visa_spring_homework002.Models.DTO.Respones.ApiResponse;
import org.example._18_mony_visa_spring_homework002.Models.Entity.Course;
import org.example._18_mony_visa_spring_homework002.Services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/show")
    public ResponseEntity<ApiResponse<List<Course>>> showCourse(@RequestParam(defaultValue = "5") Integer limit, @RequestParam(defaultValue = "0") Integer offset){
        ApiResponse<List<Course>> apiResponse = ApiResponse.<List<Course>>builder()
                .message("All courses have been successfully fetched.")
                .payload(courseService.getAll(limit, offset))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/insert")
    public ResponseEntity<ApiResponse<Course>> insertCourse(@RequestBody CourseRequest courseRequest){
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("All courses have been successfully fetched.")
                .payload(courseService.insertCourse(courseRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{search}")
    public ResponseEntity<ApiResponse<Course>> schCourse(Integer search){
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("All courses have been successfully fetched.")
                .payload(courseService.getCourseById(search))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{delbyId}")
    public ResponseEntity<ApiResponse<Course>> delCourse(Integer delbyId){
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("All courses have been successfully fetched.")
                .payload(courseService.delelteCourse(delbyId))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{upId}")
    public ResponseEntity<ApiResponse<Course>> upCourse(Integer upId, CourseRequest courseRequest){
        ApiResponse<Course> apiResponse = ApiResponse.<Course>builder()
                .message("All courses have been successfully fetched.")
                .payload(courseService.upCourse(upId, courseRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiResponse);
    }
}
