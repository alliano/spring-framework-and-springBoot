package com.basicconfiguration.spring.core.example;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype") @Lazy
@Component(value = "userService_")
public class UserService {

    public User userList() {
        User user = new User();
        user.setFirstName("Alliano");
        user.setLastName("Alfarez");
        return user;
    }
}
