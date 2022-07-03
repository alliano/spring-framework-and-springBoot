package com.basicconfiguration.spring.core;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.Foo;

public class PrimaryBeanConfigurationTet {

   public ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(PrimaryBeanConfiguration.class);
   }
   
   @Test
   void testPrimary(){
      /**
       * ini akan tidak error karna ada salah satu bean yang telah di anotasi sebagai
       * @primary jadi jikalau kita memanngil bean tampa kita panggil namanya 
       * itu secara default akan memanggil bean yang di anotasi dengan @Primary
       * disini saya menganotasi foo1 sebagai @Primary
       */
      Foo foo1 = context.getBean(Foo.class);
      //kita juga bsa memanggil dengan nama bean nya
      Foo foo = context.getBean("foo1",Foo.class);
      Foo foo2 = context.getBean("foo2",Foo.class);
      
      Assertions.assertNotNull(foo1);
      Assertions.assertNotNull(foo2);

      Assertions.assertNotSame(foo1, foo2);
      Assertions.assertNotSame(foo, foo2);
      Assertions.assertSame(foo1, foo1);
   }
}
