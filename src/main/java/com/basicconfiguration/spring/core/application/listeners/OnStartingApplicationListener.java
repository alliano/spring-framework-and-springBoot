package com.basicconfiguration.spring.core.application.listeners;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class OnStartingApplicationListener implements ApplicationListener<ApplicationStartingEvent> {
    
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("APPLICATION STARTING.......");
    }
}
