package com.example.resources;

import com.example.entities.Student;
import com.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentResource {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        Optional<Student> st = studentService.findById(id);
        if(st.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(st.get());
    }
    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student st){
        Optional<Student> student = studentService.createStudent(st);
        if(student.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(student.get().getId());
        return ResponseEntity.ok().location(uri).body(student.get());
    }
}
