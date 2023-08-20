package com.basicconfiguration.spring.core.listerner;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.event.LogginFailedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j @Component(value = "loginFailedListener")
public class LogginFaildListener implements ApplicationListener<LogginFailedEvent> {

    @Override
    public void onApplicationEvent(LogginFailedEvent event) {
        log.error("Failed Login with user {}", event.getUser().getUserName());
    }

    
}
