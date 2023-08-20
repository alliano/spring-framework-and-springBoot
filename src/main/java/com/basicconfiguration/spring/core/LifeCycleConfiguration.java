package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.MainServer;
import com.basicconfiguration.spring.core.helper.Server;
import com.basicconfiguration.spring.core.helper.lifeCycleBean.Connection;

@Configuration
public class LifeCycleConfiguration {
   
   @Bean(value = "connection")
   public Connection connection(){
      return new Connection();
   }

   /**
    * LifeCycleAnnotation
    * -------------------
    * selain menggunakan interface InitializingBean dan DisposableBean, kita juga bisa menggunakan 
    * annotation untuk mendaftar kan calback method untuk lifeCycle
    * Pada anotation @Bean terdapat method initMethod() dan destroyMehod() 
    * iniMehod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean selesai di buat
    * destroyMethod() digunakan untuk meregistrasikan method yang akan dipanggil ketika bean akan di 
    * hancurkan
    * method harus tanpa parameter, dan return value nya tidak akan di perdulikan(method harus tidak meretrun sesuatu)
    * saran ==> gunakan void method saja:) hehehe
    */

   
    @Bean(value = "server",initMethod = "start",destroyMethod = "stop")
    public Server server(){
       return new Server();
    }

    @Bean(value = "mainServer")
    public MainServer mainServer(){
       return new MainServer();
    }

}
