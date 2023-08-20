package com.basicconfiguration.spring.core.application;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
       List<String> arrays = new ArrayList<String>(Arrays.asList(args));
       arrays.addAll(List.of("nama", "watashi", "anata"));
       arrays.toArray();
    }
    
}
