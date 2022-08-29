package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {
    public static void main(String[] args) {

        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);

        IndexApp obj = (IndexApp) factory.getBean("indexApp");
        System.out.println( obj.getService());

        IndexApp obj2 = (IndexApp) factory.getBean("indexAppUsingDbService");
        System.out.println( obj2.getService());

    }
}