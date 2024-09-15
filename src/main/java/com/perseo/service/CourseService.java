package com.perseo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perseo.model.Course;
import com.perseo.repositories.ICourseRepository;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private ICourseRepository iCourseRepository;

    public List<Course> findAllCourses() {
        return iCourseRepository.findAll();
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return iCourseRepository.findById(id).map(course -> {
            course.setTitle(updatedCourse.getTitle());
            course.setDescription(updatedCourse.getDescription());
            return iCourseRepository.save(course); 
        }).orElse(null);  
    }
    
}

