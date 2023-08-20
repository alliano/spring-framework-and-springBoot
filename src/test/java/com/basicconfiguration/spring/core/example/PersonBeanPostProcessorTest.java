package com.basicconfiguration.spring.core.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.PersonBeanPostProcessorConfiguration;
import com.basicconfiguration.spring.core.helper.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonBeanPostProcessorTest {
    
    private ConfigurableApplicationContext context;
    
    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(PersonBeanPostProcessorConfiguration.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testPerson() {
        Person person = this.context.getBean(Person.class);  
        log.info("UNIQUE ID BEAN PERSON {}", person.getId());
    }
}