package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Import;

// import com.basicconfiguration.spring.core.examplecomponentscan.FooConfiguration;

@ComponentScan(basePackages = {
   "com.basicconfiguration.spring.core.repository",
   "com.basicconfiguration.spring.core.service",
   "com.basicconfiguration.spring.core.configuration",
   "com.basicconfiguration.spring.core.helper"
})
// @Import(value = {FooConfiguration.class})
@Configuration
public class ComponentConfiguration {
   
}
