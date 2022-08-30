package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.example.AppConfig;



public class Main {
    public static void main(String[] args) {

        BeanFactory factory = new AnnotationConfigApplicationContext(AppConfig.class);

        IndexApp obj = (IndexApp) factory.getBean("indexApp");
        System.out.println( obj.getService());

//        IndexApp obj2 = (IndexApp) factory.getBean("indexAppUsingDbService");
//        System.out.println( obj2.getService());

    }
}