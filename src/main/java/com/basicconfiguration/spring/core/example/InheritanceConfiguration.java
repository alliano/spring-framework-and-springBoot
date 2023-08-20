package com.basicconfiguration.spring.core.example;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.example.serviceImpl.UserServiceImpl;

@Component
@Import(value = {
    UserServiceImpl.class
})
public class InheritanceConfiguration { }