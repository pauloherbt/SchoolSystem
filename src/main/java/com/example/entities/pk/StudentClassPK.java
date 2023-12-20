package com.example.entities.pk;

import com.example.entities.Class;
import com.example.entities.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

public class StudentClassPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClassPK that = (StudentClassPK) o;
        return Objects.equals(student, that.student) && Objects.equals(aClass, that.aClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, aClass);
    }
}
