package com.basicconfiguration.spring.core.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.PersonBeanPostProcessorConfiguration;
import com.basicconfiguration.spring.core.helper.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBeanPostProcessorOrdered {
    
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(PersonBeanPostProcessorConfiguration.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testOredred() {
        Person person = this.context.getBean(Person.class);
        Assertions.assertNotNull(person.getId());
        Assertions.assertTrue(person.getId().startsWith("Second-"));
        log.info(person.getId());
    }   
}
