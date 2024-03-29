package com.basicconfiguration.spring.core.helper;

import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.aware.IdAware;

@Component
public class Car implements IdAware {

   private String Id;

   @Override
   public void setId(String id) {
     this.Id = id;
   }

   @Override
   public String getId() {
      return Id;
   }
}
