package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IndexApp {
    private IService service;

    public String getService(){
        return service.serve();
    }

    @Autowired
    @Qualifier("dbService")
    public void setService(IService service ){
        this.service = service;
    }
}
