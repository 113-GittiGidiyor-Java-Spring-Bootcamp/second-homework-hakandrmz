package dev.patika.dao;

import dev.patika.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDAO<Student> extends BaseDAO<Student> {
}
