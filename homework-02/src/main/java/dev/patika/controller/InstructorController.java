package dev.patika.controller;

import dev.patika.model.Instructor;
import dev.patika.model.PermanentInstructor;
import dev.patika.model.Student;
import dev.patika.model.VisitingResearcher;
import dev.patika.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getInstructors(){
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/instructor",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Instructor savePermanentInstructor(@RequestBody PermanentInstructor instructor){
        return instructorService.save(instructor);
    }

    @PostMapping(value = "/researcher",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Instructor saveVisitingResearcher(@RequestBody VisitingResearcher instructor){
        return instructorService.save(instructor);
    }

    @DeleteMapping("/instructor/{id}")
    public HttpStatus deleteInstructor(@PathVariable int id){
        instructorService.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/instructor")
    public Instructor updateInstructor(@RequestBody Instructor instructor){
        instructorService.update(instructor);
        return instructorService.findById(instructor.getId());
    }



}
