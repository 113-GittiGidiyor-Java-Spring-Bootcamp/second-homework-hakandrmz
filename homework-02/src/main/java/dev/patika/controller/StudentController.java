package dev.patika.controller;

import dev.patika.model.Student;
import dev.patika.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable int id){
        return new ResponseEntity<>(studentService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @DeleteMapping("/student/{id}")
    public HttpStatus deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        studentService.update(student);
        return studentService.findById(student.getId());
    }


}
