package com.basicconfiguration.spring.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

@Configuration
public class ChooseDependen {
   @Primary
   @Bean(value = "fooFrist")
   public Foo fooFrist(){
      return new Foo();
   }
   
   @Bean(value = "fooSecond")
   public Foo fooSecond(){
      return new Foo();
   }
   
   @Bean(value = "bar")
   public Bar bar(){
      return new Bar();
   }
   
   /**
    * kadang saat kita menggunakan Di, kita inigin memillih Object mana yang mau kita gunakan
    * saat terdapat duplicate bean dengan tipe data yang sama, secara otomaatis spring 
    * akan memilih bean yang di anotasi sebagai @primary namun kita jga bisa memillih secara manual 
    * cara nya kita bisa menambahkan annotasi @Qualifier(name = "nama bean nya") pada parameter di
    * method nya contoh : 
    */
    @Bean(value = "fooBar")
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo,Bar bar){
      return new FooBar(foo,bar);
    }
}
