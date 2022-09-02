package org.example.controllers;

import org.example.dtos.CourseDto;
import org.example.dtos.TopicDto;
import org.example.entities.Course;
import org.example.entities.Topic;
import org.example.services.CourseService;
import org.example.services.TopicService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/topics/{topicId}/courses")
    public List<CourseDto> getAllCourses(@PathVariable int topicId){
        List<Course> courses = courseService.getAllCourses(topicId);
        return courses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public CourseDto getCourse(@PathVariable int topicId, @PathVariable int id){
        Course course = courseService.getCourse(id);
        return convertToDto(course);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse(@PathVariable int topicId, @RequestBody CourseDto courseDto){
        Course course =convertToEntity(courseDto);
        course.setTopic(new Topic(topicId, ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses")
    public void updateCourse(@PathVariable int topicId, @RequestBody CourseDto courseDto){
        Course course =convertToEntity(courseDto);
        course.setTopic(new Topic(topicId, ""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable int id){
        courseService.deleteCourse(id);
    }

    private CourseDto convertToDto(Course course){
        return modelMapper.map(course, CourseDto.class);
    }
    private Course convertToEntity(CourseDto courseDto){
        return modelMapper.map(courseDto, Course.class);
    }
}
