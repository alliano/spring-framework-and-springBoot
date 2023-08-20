package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.service.AuthService;

@Import(value = {
    AuthService.class
})
public class AwareConfiguration { }
