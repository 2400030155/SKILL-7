package com.klu.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    // CREATE
    public Course addCourse(Course course) {
        courses.add(course);
        return course;
    }

    // READ ALL
    public List<Course> getAllCourses() {
        return courses;
    }

    // READ BY ID
    public Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // UPDATE
    public Course updateCourse(int id, Course updatedCourse) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setTitle(updatedCourse.getTitle());
                c.setDuration(updatedCourse.getDuration());
                c.setFee(updatedCourse.getFee());
                return c;
            }
        }
        return null;
    }

    // DELETE
    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getCourseId() == id);
    }

    // SEARCH BY TITLE
    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }
        return result;
    }
}
