package org.example;

public class DbService implements IService{
    @Override
    public String serve() {
        return "Database connected successfully";
    }

}
