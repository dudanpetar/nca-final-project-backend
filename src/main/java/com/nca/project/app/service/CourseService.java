package com.nca.project.app.service;

import com.nca.project.app.model.Course;
import com.nca.project.app.persistence.CourseRepository;
import com.sun.org.apache.bcel.internal.generic.CPInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public void deleteCourse(Course course){
       courseRepository.delete(course);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course getCourseById(long id) {
         Optional<Course> resp = courseRepository.findById(id);
         if( resp.isPresent())
             return resp.get();
         return null;
    }
}
