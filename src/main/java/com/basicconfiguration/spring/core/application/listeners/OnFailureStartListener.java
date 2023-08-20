package com.basicconfiguration.spring.core.application.listeners;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

public class OnFailureStartListener implements ApplicationListener<ApplicationFailedEvent> {

    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        System.out.println("APPLICATION FAILED START ..............................");
    }
    
}
