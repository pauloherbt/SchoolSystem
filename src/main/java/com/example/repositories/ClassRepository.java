package com.example.repositories;

import com.example.entities.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class,Long> {
}
