package com.basicconfiguration.spring.core.listerner;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.event.LogginSuccessEvent;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LogginSuccessListener implements ApplicationListener<LogginSuccessEvent> {

   @Override
   public void onApplicationEvent(LogginSuccessEvent event) {
      log.info("success loggin for user {} ", event.getUser().getUserName());
   }
}
