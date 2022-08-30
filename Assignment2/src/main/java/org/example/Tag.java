package org.example;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Tag {
    public Date manufactureDate;
    public String model;


    Tag(){
        this.manufactureDate = new Date();
        this.model = "1999";
    }
    Tag(Date date, String model){
        this.manufactureDate = date;
        this.model = model;
    }


}
