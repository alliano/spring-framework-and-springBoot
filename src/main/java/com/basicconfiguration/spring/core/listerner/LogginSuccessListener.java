package com.basicconfiguration.spring.core.listerner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.event.LogginSuccessEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogginSuccessListener implements ApplicationListener<LogginSuccessEvent>{

   private Logger logger = LoggerFactory.getLogger(LogginSuccessListener.class);

   @Override
   public void onApplicationEvent(LogginSuccessEvent event) {
      logger.info("success loggin for user {} ", event.getUser().toString());
   }
   
}
