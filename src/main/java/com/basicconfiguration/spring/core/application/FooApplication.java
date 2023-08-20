package com.basicconfiguration.spring.core.application;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.basicconfiguration.spring.core.application.listeners.OnFailureStartListener;
import com.basicconfiguration.spring.core.application.listeners.OnStartingApplicationListener;
import com.basicconfiguration.spring.core.helper.Foo;

/**
 * Saat kita menggunakan annotation @SpringBootApplication
 * jikalau ada sub package dari package milik main class
 * dalam contoh ini adalah com.basicconfiguration.spring.core.application
 * maka secara otomatis akan di import oleh springBoot 
 * jadi kita tidak perlu lagi meng import secara manual menggunakan
 * @Import ataupun @ComponentScan
 */
@SpringBootApplication
public class FooApplication {

   @Bean(name = "fooApp")
   public Foo foo() {
      return new Foo();
   }

   // public static void main(String... args) {
   //    ConfigurableApplicationContext context = SpringApplication.run(FooApplication.class, args);
   //    FooXPerson fooxPerson = context.getBean(FooXPerson.class);
   //    System.out.println(fooxPerson.getEnvironment());
   // }

   public static void main(String... args) {
      SpringApplication springApplication = new SpringApplication(FooApplication.class);
      springApplication.setListeners(List.of(new OnStartingApplicationListener(), new OnFailureStartListener()));
      springApplication.run(args);
      System.out.println(Arrays.asList(args));
   }
}
