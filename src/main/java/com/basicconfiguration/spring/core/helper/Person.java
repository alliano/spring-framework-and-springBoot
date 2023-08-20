package com.basicconfiguration.spring.core.helper;

import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.aware.IdAware;

@Component(value = "Person")
public class Person implements IdAware {
    
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
       return this.id;
    }
}
