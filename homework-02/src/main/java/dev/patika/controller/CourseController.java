package dev.patika.controller;

import dev.patika.model.Course;
import dev.patika.model.Student;
import dev.patika.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/course")
    public Course saveCourse(@RequestBody Course course){
        return courseService.save(course);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Student>> getAllCourses(){
        return new ResponseEntity(courseService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/course/{id}")
    public HttpStatus deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/course")
    public Course updateCourse(@RequestBody Course course){
        courseService.update(course);
        return courseService.findById(course.getId());
    }


}
