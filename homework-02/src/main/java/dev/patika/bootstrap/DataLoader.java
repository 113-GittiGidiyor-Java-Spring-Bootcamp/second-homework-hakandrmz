package dev.patika.bootstrap;

import dev.patika.model.*;
import dev.patika.service.CourseService;
import dev.patika.service.InstructorService;
import dev.patika.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentService studentService;
    private final CourseService courseService;
    private final InstructorService instructorService;

    public DataLoader(StudentService studentService, CourseService courseService, InstructorService instructorService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.instructorService = instructorService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = studentService.findAll().size();
        System.out.println(count);

        if(count < 50) {
          loadData();
        }

    }

    private void loadData() {

        Student stu1 = new Student("Hakan", LocalDate.of(2001, 1, 13),"Bursa","M");
        Student stu2 = new Student("Ali", LocalDate.of(2002, 2, 14),"İstanbul","M");
        Student stu3 = new Student("Ayşe",LocalDate.of(2003, 3, 15),"Ankara","F");
        Student stu4 = new Student("Fatma",LocalDate.of(2004, 4, 16),"Adana","F");
        Student stu5 = new Student("Mehmet",LocalDate.of(2005, 7, 17),"Erzurum","M");

        Course course1 = new Course("Algorithm 101","ALG101",6);
        Course course2 = new Course("Data Structures","DS102",5);

        Instructor pi = new PermanentInstructor("Celal","ITU","918273645",100);
        Instructor vr = new VisitingResearcher("Dilan","Kayseri","918273645",300);

        course1.setInstructor(pi);
        course2.setInstructor(vr);

        course1.getStudents().add(stu1);
        course1.getStudents().add(stu2);
        course1.getStudents().add(stu3);
        course1.getStudents().add(stu4);
        course2.getStudents().add(stu3);
        course2.getStudents().add(stu4);
        course2.getStudents().add(stu5);

        instructorService.save(pi);
        instructorService.save(vr);

        studentService.save(stu1);
        studentService.save(stu2);
        studentService.save(stu3);
        studentService.save(stu4);
        studentService.save(stu5);

        courseService.save(course1);
        courseService.save(course2);

    }
}
