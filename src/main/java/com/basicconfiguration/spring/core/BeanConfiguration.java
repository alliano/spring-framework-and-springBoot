package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basicconfiguration.spring.core.helper.Foo;

import lombok.extern.slf4j.Slf4j;





/**
 * Bean adalah suatu object yang di masukan di dala ioc atau configuration
 * saat suatu object kita masukan ke dalam container ioc maka kita sebut
 * object tersebut adalah Bean
 * secara default Bean adalah SingleTon artinya jika kita mengakses bean yang sama 
 * maka akan di kembalikan Bean yang sama juga
 */
@Slf4j
@Configuration
public class BeanConfiguration {

    /**
     * untuk membaut bean tambahkan anotasi @Bean di atas method
     * contoh bean
     */

   @Bean
   public Foo foo(){
      return new Foo();
   }
    /**
     * setelah membaut bean secara otomatis semua object di manatge oleh ApplicationContext
     * untuk mengakses nya kita bisa menggunakan method getBean milik ApplicationContext
     */
   
}
