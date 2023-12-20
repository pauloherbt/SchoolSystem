package com.example.repositories;

import com.example.entities.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentClassRepository extends JpaRepository<StudentClass,Long> {
}
