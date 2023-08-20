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
    * dengan ketentuan Obejct parameter tersebut telah memiliki Bean nya
    * dalam konteks ini Bean pada parameter nya telah dibuatkan pada statement diatas
    */
    @Bean(value = "fooBar")
    public FooBar fooBar(Foo foo,Bar bar){
       return new FooBar(foo,bar);
    }
}
