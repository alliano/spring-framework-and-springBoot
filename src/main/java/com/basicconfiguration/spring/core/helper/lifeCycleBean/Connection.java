package com.basicconfiguration.spring.core.helper.lifeCycleBean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.extern.slf4j.Slf4j;

/**
 * Spring container memiliki alur hidup, dan jika kita ingin ber intraksi dengan alur hidupnya
 * spring (life cycle) kita juga bisa lakukan 
 * saat pertamakali spring berjalan dan sudah selesai membaut bean, spring akan memberi tau
 * bean tersebut bahwa bean tersenbut sdah siap, artinya semua dependencies sudah dimasukan 
 * kedalam spring container.
 * dan ketika applikasi spring akan mati, spring juga akan memberi tau semua bean bahwa 
 * bean tersebuat akan di hancurkan
 */

 /**
  * LIFE CYCLE CALL BACK
  * secara default bean tiadak mengetahui lifecycle spring ketika selesai mmebuat bean dan 
  * ketika akan menghancurkan bean 
  * jika kita ingin berintraksi dengan lifecycle spring kita bisa meng implememntasi interface
  * InitializingBean dan DisposableBean
  * InitializingBean digunakan jika kita ingin berinteraksi ketika spring selesai membaut bean
  * DisposableBean digunakan ketika kita ingin berinteraksi ingin menghancurkan bean.
  */
@Slf4j
public class Connection implements InitializingBean, DisposableBean {

   /**
    * method ini akan secara otomatis di panggil ketika spring telah selesai membuat Bean
    */
   @Override
   public void destroy() throws Exception {
      log.info("connection has closed");
      
   }

   /**
    * method ini akan di panggil secara otomatis ketika appl;ikasi spring di matikan
    */
   @Override
   public void afterPropertiesSet() throws Exception {
      log.info("connection has ready to be use");
      
   }
   
}
