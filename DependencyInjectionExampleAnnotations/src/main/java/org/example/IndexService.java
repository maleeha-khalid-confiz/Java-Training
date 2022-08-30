package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class IndexService implements IService{

    public String serve() {
        return "Hello World";
    }
}
