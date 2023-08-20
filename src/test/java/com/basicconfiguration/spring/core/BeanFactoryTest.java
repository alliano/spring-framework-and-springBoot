package com.basicconfiguration.spring.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;

public class BeanFactoryTest {
   
   // ConfigurableApplicationContext juga merupakan interface turunan dari ListableBeanFactory
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void testBean(){

      //ini mereturn bean tapi kita tidak dengan nama bean nya
      ObjectProvider<Foo> foo = this.context.getBeanProvider(Foo.class);
      List<Foo> collection = foo.stream().collect(Collectors.toList());
      System.out.println(collection);
      Assertions.assertEquals(3, collection.size());

      //ini mereturn bean  dan nama bean nya
      Map<String,Foo> beans = this.context.getBeansOfType(Foo.class);
      Assertions.assertEquals(3, beans.size());
   }
}
