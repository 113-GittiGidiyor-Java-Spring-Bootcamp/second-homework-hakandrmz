package dev.patika.service;

import dev.patika.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService extends BaseService<Student>{
    Student delete(Student student);
}
