package com.basicconfiguration.spring.core.helper.scope;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class DoubletonScope implements Scope {

   private List<Object> objects = new ArrayList<Object>(2);
   private Long counter = -1L;

   /**
    * method ini memiliki 2 parameter yang pertama adalah parameter untuk nama object nya
    * ke 2 untuk object nya
    * properti object utuk menyimpan object kedalam arrayList 
    * properti count untuk menghitung berapa kali object dipanggil
    * jika jumlah object itu sama dengan 2 maka counter akan di modulus 2 maka hasilnya 0
    * dan akan mengembalikan object dengan index ke 0 
    * dan jika object nya tidak sama dengan 2 maka object akan di tambahkan 1 object
    */
   @Override
   public Object get(String name, ObjectFactory<?> objectFactory) {
      counter++;
      if(objects.size() == 2) {
         int index = (int)(counter % 2);
         return objects.get(index);
      }
      else{
          Object object = objectFactory.getObject();
          objects.add(object);
          return object;
      }
   }

   @Override
   public Object remove(String name) {
      if(!objects.isEmpty())return this.objects.remove(0);
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
