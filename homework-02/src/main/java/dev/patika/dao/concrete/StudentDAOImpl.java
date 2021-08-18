package dev.patika.dao.concrete;

import dev.patika.model.Student;
import dev.patika.dao.StudentDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List findAll() {
        return entityManager.createQuery("From Student",Student.class).getResultList();
    }

    @Override
    public Object findById(long id) {
        return null;
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(Object o) {

    }
}
