package dev.patika.service.concrete;

import dev.patika.model.Course;
import dev.patika.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course save(Course object) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(Course course) {

    }
}
