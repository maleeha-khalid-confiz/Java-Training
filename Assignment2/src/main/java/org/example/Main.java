package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        BeanFactory factory = new AnnotationConfigApplicationContext(AppConfig.class);

        Tag tag = (Tag) factory.getBean("tag");
        Car car = (Car) factory.getBean("car");
        System.out.println(car.tag.model);
        System.out.println(car.tag.manufactureDate);

    }
}