package com.example.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long register;
    private String number;
    private String password;

    @OneToMany(mappedBy = "id.student")
    private Set<StudentClass> classes = new HashSet<>();

    public Student(){
    }
    public Student(Long id, String name, Long register, String number, String password) {
        this.id = id;
        this.name = name;
        this.register = register;
        this.number = number;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Long getRegister() {
        return register;
    }

    public Set<StudentClass> getStudentClasses() {
        return classes;
    }

    public void setStudentClasses(Set<StudentClass> studentClasses) {
        this.classes = studentClasses;
    }


    public void setRegister(Long register) {
        this.register = register;
    }
}
