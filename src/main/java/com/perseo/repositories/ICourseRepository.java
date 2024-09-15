package com.perseo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perseo.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    
}

