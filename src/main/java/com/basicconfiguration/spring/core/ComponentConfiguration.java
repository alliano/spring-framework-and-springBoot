package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {
   "com.basicconfiguration.spring.core.repository",
   "com.basicconfiguration.spring.core.service",
   "com.basicconfiguration.spring.core.configuration",
   "com.basicconfiguration.spring.core.helper"
})
@Configuration
public class ComponentConfiguration { }
