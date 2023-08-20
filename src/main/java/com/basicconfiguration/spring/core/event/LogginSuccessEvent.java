package com.basicconfiguration.spring.core.event;

import org.springframework.context.ApplicationEvent;

import com.basicconfiguration.spring.core.helper.User;

import lombok.Getter;
import lombok.Setter;

/**
 * Event Listener
 * 
 * Spring memiliki fitur EventListener yang bisa kita gunakan untuk berkomunikasi antar class
 * menggunakan Event
 * Event di spring merupakan Object turunan dari ApplicationEvent, sddangkan Listener di spring 
 * merupakan turunan dari ApplicationListener 
 * 
 * Application Event Publisher
 * 
 * ketika kita meu mengirimkan Event ke listener kita bisa menggunkan object ApplicationEventPublisher
 * yang mana ApplicationEventPublisher merupakan super interface dari ApplicationContex
 * atau kita bisa menggunakan ApplicationEventPublisherAware untuk mendapatkan object ApplicationEventPublisher
 * 
 */

@Setter @Getter
public class LogginSuccessEvent extends ApplicationEvent {
   
   private User user;

   public LogginSuccessEvent(User user) {
      super(user);
      this.user = user;
   }
}
