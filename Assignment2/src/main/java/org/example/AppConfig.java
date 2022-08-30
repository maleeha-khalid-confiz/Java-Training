package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class AppConfig {

    @Bean
    public Tag tag(){
        Date date = new Date();
        String model = "1999";
        return  new Tag (date, model);
    }

    @Bean
    public Car car(){
        Car car = new Car();
        car.setTag(tag());
        return car;
    }
}
