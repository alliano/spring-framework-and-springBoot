package com.basicconfiguration.spring.core;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DependsOnConfiguration {
 
   private Logger logger = (Logger) LoggerFactory.getLogger(DependsOnConfiguration.class);
   
   /*
    * saat bean membutuhkan bean lain secara otomatis bean tersebuat akan di buat setelah bean yang
    * dibutuhkan dibuat
    * namun bagaimana jika bean tersebut tidak membutuhkan bean lain,namun kita ingin sebuah bean di buat 
    * setelah bean lain di buat?
    * kita bisa menggunakan annotasi @DependsOn({"nama bean "}) atau @DependsOn(value = "nama bean ") didalam 
    * parameter @DependsOn(value = "") kita iskan nama bean yang dibuat terlebih dahulu daripada 
    * bean yang di annotasi sebagai @DependsOn();
    * secara otomatis Spring akan memprioritaskan pembuatan bean yang terdapat didalam annotasi
    * @DependsOn() terlebih dahulu.
    * Contoh : 
    */

    /**
     * bena ini kan dibuat setelah bean barDependensOn
     * @return
     */
   @DependsOn({"barDependsOn"})
   @Bean(value = "fooDependsOn")
   public Foo foo(){    
     logger.info("===========creating Foo============");
      return new Foo();
   }

   @Bean(value = "barDependsOn")
   public Bar bar(){
      logger.info("========Creating bar=========");
      return new Bar();
   }
}
