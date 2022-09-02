package org.example.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    private int Id;
    private String name;
    private TopicDto topic;
}
