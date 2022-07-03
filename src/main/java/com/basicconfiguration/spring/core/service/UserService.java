package com.basicconfiguration.spring.core.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.event.LogginSuccessEvent;
import com.basicconfiguration.spring.core.helper.User;

@Component
public class UserService implements ApplicationEventPublisherAware{
   
   private ApplicationEventPublisher applicationEventPublisher;

   @Override
   public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
     this.applicationEventPublisher = applicationEventPublisher;
   }
   public boolean login(String userName, String password){
      if(isLoginSucces(userName, password)){
         this.applicationEventPublisher.publishEvent(new LogginSuccessEvent(new User(userName)));// => mengirim Event nya
         return true;
      }else{
         return false;
      }
   }

   public boolean isLoginSucces( String userName, String password){
      return "alliano".equals(userName) && "hagoromo".equals(password);
   }
   

}
