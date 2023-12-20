package com.example.entities;

import com.example.entities.pk.StudentClassPK;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_student_class")
public class StudentClass {
    @EmbeddedId
    private StudentClassPK id = new StudentClassPK();
    private String task;
    private double nota;

    public StudentClass() {
    }

    public StudentClass(String task, double nota, Student student, Class aClass) {
        this.task=task;
        this.nota = nota;
        setStudent(student);
        setClass(aClass);
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Student getStudent() {
        return id.getStudent();
    }

    public Class getaClass() {
        return id.getaClass();
    }
    public void setStudent(Student student){
        id.setStudent(student);
    }
    public void setClass(Class aclass){
        id.setaClass(aclass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClass that = (StudentClass) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
