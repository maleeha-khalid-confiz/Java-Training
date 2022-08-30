package org.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DbService implements IService{
    @Override
    public String serve() {
        return "Database connected successfully";
    }

}
