package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Car {
    Tag tag;

    public void setTag(Tag tag){
        this.tag = tag;
    }

}
