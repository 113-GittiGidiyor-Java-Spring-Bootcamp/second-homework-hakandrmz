package dev.patika.service.concrete;

import dev.patika.dao.InstructorDAO;
import dev.patika.model.Instructor;
import dev.patika.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorDAO instructorDAO;

    public InstructorServiceImpl(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    public Instructor findById(int id) {
        Instructor foundInstructor = instructorDAO.findById(id);
        return foundInstructor;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorDAO.save(instructor);
    }

    @Override
    public void deleteById(int id) {
        instructorDAO.delete(id);
    }

    @Override
    public void update(Instructor instructor) {

    }
}
