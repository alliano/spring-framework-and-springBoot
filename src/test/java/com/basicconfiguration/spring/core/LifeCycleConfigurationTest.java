package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.MainServer;
import com.basicconfiguration.spring.core.helper.Server;
import com.basicconfiguration.spring.core.helper.lifeCycleBean.Connection;

public class LifeCycleConfigurationTest {

   /**
    * agar nanti ketika applikasi spring akan di matikan secara otomatis akan mengclose connection
    * kita harus mengganti Applicationcontex dengan ConfigurableApplicationContex untuk mengkases 
    * method close();
    * karna di class ApplicationContex tidak ada method close();
    */
   // private ApplicationContext context;
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
      this.context.registerShutdownHook();
   }
   @AfterEach
   void teatDown(){
      /**
       * jika kita tidak mau melakukan secara manual untuk meng destroy connection kita bisa melakukan 
       * dengan method registerShutDownHook(); 
       */
      // this.context.close();
   }

   @Test
   void lifeCycleTest(){
      Connection connection = this.context.getBean("connection",Connection.class);
      Assertions.assertNotNull(connection);

      /**
       * kita tidak perlu melakukan connection.afterPropertySet(); untuk mengeksekusi suatu bean
       * ketia spring telah membuat bean klaena secara otomatis spring akan mengeksekusi nya setelah
       * bean selesai di buat.
       * dan kita tidak perlu melakukan connection.destroy(); karna secara otomatis spring akan memberi 
       * tau kepada bean nya jikalau mau di hancurkan jadi secara otomatis nanti akan di close by spring
       */
   }


    /*
     * ini kita tidak perlumeng close karna menggunakan lifeCycle annotation 
     * secara otomatis akan di jalankan ketika bean nya telah dibuat dan secara otoimatis jga akan di close ketika
     * applikasi spring akan di matikan
     */
   @Test
   void testServer(){
      Server server = this.context.getBean("server",Server.class);
      Assertions.assertNotNull(server);
   }

   /**
    * ini kita tidak perlu meng close jga karna secara default telah di handle oleh 
    * annotation @PreConstruct dan @PreDestroy
    */
   @Test
   void testMainServer(){
      MainServer mainServer = this.context.getBean("mainServer",MainServer.class);
      Assertions.assertNotNull(mainServer);
   }
}
