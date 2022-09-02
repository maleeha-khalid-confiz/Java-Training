package org.example.dtos;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TopicDto {

    private int Id;

    @NotNull(message = "Topic can not be null!")
    private String name;
}
