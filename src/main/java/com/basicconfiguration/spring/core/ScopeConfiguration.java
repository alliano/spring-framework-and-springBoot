package com.basicconfiguration.spring.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ScopeConfiguration {

   /**
    * scope merupakan strategy cara sebuah object di buat secara default object di spring dibuat 
    * dengan singleton artinya hanya sekali ketika kita akses/butuhkan dan jika kita akses ke 2x 
    * nya maka akan menggembalikan object yang sama
    * namaun kita jga bisa menggubah scope bean yang kita mau di spring 
    * untuk mengubah sebuah scope di bean kita bisa mengguakan annotasi @Scope(value = "nama secope nya") 
    * jika kita tidak tambahkan annotasi @Scope() by default spring akan menggunakan secope singleton
    */

   @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
   @Bean(value = "fooScope")
   public Foo foo(){
      log.info("===>Foo Scope has created<===");
      return new Foo();
   }
}
