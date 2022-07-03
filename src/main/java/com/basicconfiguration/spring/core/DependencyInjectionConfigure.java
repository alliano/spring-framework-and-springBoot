package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

@Configuration
public class DependencyInjectionConfigure {
  
   
   @Bean(value = "foo")
   public Foo foo(){
      return new Foo();
   }

   @Bean(value = "bar")
   public Bar bar(){
      return new Bar();
   }

   /**
    * untuk dependency injction secara otomatis kita bisa set seperti ini
    * kita cukup set sebagai parameter saja disini
    * @param foo
    * @param bar
    * @return
    */
    @Bean(value = "fooBar")
    public FooBar fooBar(Foo foo,Bar bar){
       return new FooBar(foo,bar);
    }



  
}
