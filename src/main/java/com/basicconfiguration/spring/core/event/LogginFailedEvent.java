package com.basicconfiguration.spring.core.event;

import org.springframework.context.ApplicationEvent;

import com.basicconfiguration.spring.core.helper.User;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class LogginFailedEvent extends ApplicationEvent {

    private User user;

    public LogginFailedEvent(User user) {
        super(user);
        this.user = user;
    }  
}