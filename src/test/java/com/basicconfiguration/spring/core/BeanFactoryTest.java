package com.basicconfiguration.spring.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.Foo;

public class BeanFactoryTest {
   
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
      this.context.registerShutdownHook();
   }
   /**
    * Bean factory hanya bisa digunakan untuk mengakses singggle bean, artimnya jika terdapat
    suingle bean dengan tipe yang sama, kitaharus sebut 1 per satu nama bean nya 
    Listable Bean Factory adalah turunan darti Bean factory yang bisa kita gunakan untuk mengakses 
    bebrapa bean sekaligus 
    dalam beberapa kasusu ini sangan berguna seperti misal kita inggin mengambil semua bean dengan
    tipe tertentu
    ApplicationContex juga merupakan turunan dari inrterface Listable Bean Factory
    */

   @Test
   void testBean(){

      //ini mereturn bean tapi kita tidak dengan nama bean nya
      ObjectProvider<Foo> foo = this.context.getBeanProvider(Foo.class);
      List<Foo> collection = foo.stream().collect(Collectors.toList());
      System.out.println(collection);

      //ini mereturn bean  dan nama bean nya
      Map<String,Foo> beans = this.context.getBeansOfType(Foo.class);
      System.out.println(beans);
   }
}
