package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.importConfig.MainConfiguration;

public class ImportConfigurationTest {
   
   private ConfigurableApplicationContext context;
   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(MainConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void testMainConf(){
      Foo foo = this.context.getBean(Foo.class);
      Bar bar = this.context.getBean(Bar.class);

      Assertions.assertNotSame(foo, bar);
   }
}
