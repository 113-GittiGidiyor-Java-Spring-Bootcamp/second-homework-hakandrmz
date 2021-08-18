package dev.patika.service.concrete;

import dev.patika.dao.CourseDAO;
import dev.patika.model.Course;
import dev.patika.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseDAO courseDAO;

    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(int id)   {
        Course foundCourse = courseDAO.findById(id);
        return foundCourse;
    }

    @Override
    public Course save(Course object)   {
        return courseDAO.save(object);
    }

    @Override
    public void deleteById(int id) {
        courseDAO.delete(id);
    }

    @Override
    public void update(Course course) {

    }
}
