package dev.patika.service.concrete;

import dev.patika.dao.StudentDAO;
import dev.patika.model.Student;
import dev.patika.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        Student foundStudent = (Student) studentDAO.findById(id);
        return foundStudent;
    }

    @Override
    public Student save(Student student) {
        return (Student) studentDAO.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentDAO.delete(id);
    }

    @Override
    public void update(Student student) {

    }
}
