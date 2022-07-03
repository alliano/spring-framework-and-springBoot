package com.basicconfiguration.spring.core;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.basicconfiguration.spring.core.helper.Foo;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ScopeConfiguration {
   
   private Logger logger = (Logger) LoggerFactory.getLogger(ScopeConfiguration.class);

   /**
    * scope merupakan strategy cara sebuah object di buat secara default object di spring dibuat 
    * dengan singleton artinya hanya sekali ketika kita akses/butuhkan dan jika kita akses ke 2x 
    * nya maka akan menggembalikan object yang sama
    * namaun kita jga bisa menggubah scope bean yang kita mau di spring 
    * untuk mengubah sebuah scope di bean kita bisa mengguakan annotasi @Scope(value = "nama secope nya") 
    * jika kita tidak tambahkan annotasi @Scope() by default spring akan menggunakan secope singleton
    */

    /**
     * **********************************************************************+
     * Scope         |keterangan                                             |
     * **********************************************************************+
     * single ton    |(Default) hanya di buat 1x dalam spring ioc            *
     * prototype     |selalu di buatkan object baru setiap kali bean di akses*
     * request       |dibuat baru per HTTP Request (hanya untuk web App)     *
     * session       |dibuatkan baru per HTTP session (hanya untuk web App)  *
     * application   |dibuatkan baru per ServletContex(hanya untuk web App)  *
     * webSocket     |dibuat baru per WebSocket (hanya untuk webSocket App)  *
     * **********************************************************************+
     * 
     */

   @Scope(value = "prototype")
   @Bean(value = "fooScope")
   public Foo foo(){
      logger.info("===>Foo Scope has created<===");
      return new Foo();
   }
}
