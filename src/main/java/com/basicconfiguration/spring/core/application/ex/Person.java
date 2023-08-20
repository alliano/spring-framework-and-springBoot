package com.basicconfiguration.spring.core.application.ex;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Component(value = "person")
public class Person {
    
    private String name = "Alliano";

}
