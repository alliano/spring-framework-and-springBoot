package com.basicconfiguration.spring.core.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@Setter @Getter @NoArgsConstructor
public class User {
    
    private String firstName;

    private String lastName;
}
