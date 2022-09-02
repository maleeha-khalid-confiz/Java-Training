package org.example.services;

import org.example.data.CourseRepository;
import org.example.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Value("$print-message")
    private String message;

    public List<Course> getAllCourses(int topicId){

        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse(int id){
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course){

        courseRepository.save(course);
    }

    public void updateCourse(Course course){

        courseRepository.save(course);
    }

    public void deleteCourse(int id){

        courseRepository.deleteById(id);
    }

    public String getMessage() {
        return message;
    }


}
