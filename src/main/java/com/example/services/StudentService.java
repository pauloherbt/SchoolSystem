package com.example.services;

import com.example.entities.Student;
import com.example.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }
    public Optional<Student> findByRegister(Long id){
        return studentRepository.findByRegister(id);
    }
    public Optional<Student> createStudent(Student student){
        if(student.getId()==null&&findByRegister(student.getRegister()).isEmpty())
            return Optional.of(studentRepository.save(student));
        return Optional.empty();
    }
}
