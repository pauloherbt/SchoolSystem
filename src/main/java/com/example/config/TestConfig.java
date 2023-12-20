package com.example.config;

import com.example.entities.Class;
import com.example.entities.Student;
import com.example.entities.StudentClass;
import com.example.entities.Teacher;
import com.example.repositories.ClassRepository;
import com.example.repositories.StudentClassRepository;
import com.example.repositories.StudentRepository;
import com.example.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentClassRepository studentClassRepository;
    @Override
    public void run(String... args) throws Exception {
        Teacher t1 = new Teacher(null,"Josefran","12345678","123456");
        Teacher t2 = new Teacher(null,"Rui","12345678","123456");
        Teacher t3 = new Teacher(null,"Danilo","12345678","123456");
        Class c1 = new Class(null,"Paradigmas", LocalDate.now(),LocalDate.now().plusDays(30),t1);
        Class c2 = new Class(null,"Series", LocalDate.now(),LocalDate.now().plusDays(30),t2);
        Class c3 = new Class(null,"fis exp", LocalDate.now(),LocalDate.now().plusDays(30),t3);
        List<Student> studentList = List.of(new Student(null,"Paulo Herbert",141455L,"12334","12345"),
                new Student(null,"Paulo Icaro",1978144L,"12334","12345"),
                new Student(null,"Cize Lucas",184814814L,"12334","12345"));
        teacherRepository.saveAll(List.of(t1,t2,t3));
        classRepository.saveAll(List.of(c1,c2,c3));
        studentRepository.saveAll(studentList);
        StudentClass st = new StudentClass("Fazer coisas",7, studentRepository.getReferenceById(2L), classRepository.getReferenceById(1L));
        StudentClass st2 = new StudentClass("Fazer outras cisas",6, studentRepository.getReferenceById(3L), classRepository.getReferenceById(2L));
        StudentClass st3 = new StudentClass("Fazer mais coisas",7, studentRepository.getReferenceById(2L), classRepository.getReferenceById(3L));
        studentClassRepository.saveAll(List.of(st3,st2,st));

    }
}
