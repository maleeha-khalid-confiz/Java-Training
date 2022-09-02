package org.example.data;

import org.example.entities.Course;
import org.example.entities.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
    public List<Course> findByTopicId(int topicId);
}
