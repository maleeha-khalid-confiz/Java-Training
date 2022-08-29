package org.example;

public class IndexApp {
    private IService service;

    public String getService(){
        return service.serve();
    }

    public void setService(IService service ){
        this.service = service;
    }
}
