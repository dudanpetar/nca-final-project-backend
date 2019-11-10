package com.nca.project.app.controller;

import com.nca.project.app.model.Course;
import com.nca.project.app.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
 * ToDo: replace System.out.print with proper logger
 */

@RestController
@RequestMapping("/app/course")
@CrossOrigin(origins = "http://localhost:4200")
public class courseController {
    @Autowired
    CourseService courseService;


    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Course> getCourses() {
        System.out.println("getCourses controller is called");
        List<Course> courses = courseService.getAllCourses();
        return courses;
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Course getCourseById( @PathVariable long id){
        System.out.println("getCourseById controller is called, id: " + id);

        Course course = courseService.getCourseById(id);

        return course;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public ResponseEntity deleteCourse(@RequestBody Course course){
        System.out.println("deleteCourse controller is called");

        courseService.deleteCourse(course);
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ResponseEntity insertCourse( @RequestBody Course course) {
        System.out.println("insertCourse controller is called");
        System.out.println(course.toString());
        if(course == null)
            return (ResponseEntity) ResponseEntity.badRequest();

        Course result = courseService.saveCourse(course);
        System.out.println("Save result " + result.toString());
        if(result == null)
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);

        return ResponseEntity.ok(true);
    }



}
