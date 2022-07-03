package com.basicconfiguration.spring.core.helper.scope;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * jika scope yang di sediakan spring tidak memenuhi kebutuhan kita, kita bisa membuat scope sendiri
 * caranya dengan membuat class yang implement interface scope
 * selanjutnya untuk meregistrasikan kita bisa mebuat CostomScopeConfigurer didalam class yang di annotasi
 * sebagai @Configuration dan didalam method yang di annotasi sebagai @Bean
 */

public class DoubletonScope implements Scope {

   private List<Object> object = new ArrayList<>(2);
   private Long counter = -1L;

   /**
    * method ini memiliki 2 parameter yang pertama adalah parameter untuk nama object nya
    * ke 2 untuk object nya
    * properti object utuk menyimpan object dengan array list 
    * properti count untuk menghitung berapa kali object dibuat
    * jika jumlah object itu sama dengan 2 maka counter akan di modulus 2 maka hasilnya 0
    * dan akan mengembalikan object dengan index ke 0 
    * dan jika object nya tidak sama dengan 2 maka object akan di tambahkan 1 object
    */
   @Override
   public Object get(String name, ObjectFactory<?> objectFactory) {
      this.counter++;
      if(this.object.size() == 2) {
         return this.object.get((int) (counter % 2));
      }else{
         Object object = objectFactory.getObject();
         return this.object.add(object);
      }
      
      
   }

   @Override
   public Object remove(String name) {
      if(!this.object.isEmpty())return this.object.remove(0);
      return null;
   }

   @Override
   public void registerDestructionCallback(String name, Runnable callback) {}

   @Override
   public Object resolveContextualObject(String key) {
      return null;
   }

   @Override
   public String getConversationId() {
      return null;
   }
   
}
