package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;


public class DuplicateBeanTest {

   private ApplicationContext applicationContext;

   @BeforeEach
   void setup() {
      this.applicationContext = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
   }

   @Test
   void duplicateTestBean(){
      /**
       * ini akan error karna spring nya akan tidakdapat menemukan Bean dengan nama Foo
       * karna spring mnya mendapatkan 2 Bean jadi Spring nya bingung Foo yang mna yang di maksud karna
       * expetasi kita ingin mendapat kan 1 Bean foo namun kita mendapatkan 2 Bean foo
       *
       */
      Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> applicationContext.getBean(Foo.class));
   }

   @Test
   void test(){
      /**
       * jikalau kita memiliki 2 Tipe bean yang sama maka jikalau kita mauu memanggilnya
       * harus kita panggil nama dan tipe Bean nya
       */
      Foo foo1 = this.applicationContext.getBean("foo1",Foo.class);
      Foo foo2 = this.applicationContext.getBean("foo2",Foo.class);

      /**
       * ini kikalau kita panggil berkali2 object Foo1 atau Foo2 tetap
       * hanya dibuat 1x
       * karna itu memmang perilaku singleton
       */
      Assertions.assertNotNull(foo1);
      Assertions.assertNotNull(foo2);

      Assertions.assertNotSame(foo1, foo2);

   }
}
