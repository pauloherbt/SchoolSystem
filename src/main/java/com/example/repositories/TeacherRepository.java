package com.example.repositories;

import com.example.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
