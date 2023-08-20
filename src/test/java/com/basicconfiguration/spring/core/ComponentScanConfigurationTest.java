package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;

public class ComponentScanConfigurationTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        this.applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
        this.applicationContext.registerShutdownHook();
    }

    @Test
    public void testComponentScan() {
        Foo foo = this.applicationContext.getBean("foo", Foo.class);
        Bar bar = this.applicationContext.getBean("bar", Bar.class);
        Assertions.assertNotNull(bar);
        Assertions.assertNotNull(foo);
    }
}
