package com.basicconfiguration.spring.core;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

@Configuration
public class OptionalConfiguration {

   @Bean(value = "foo")
   public Foo foo(){
      return new Foo();
   }

   @Bean(value = "fooBar")
   /**
    * dengan membungkus parameter nya dengan Optional
    * maka jikalau bean nya tidak ditemukan maka tidak akan terjadi error
    * karena Dependency nya bersifat Optional
    */
   public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar){
      return new FooBar(foo.orElse(null),bar.orElse(null));
   }
}
