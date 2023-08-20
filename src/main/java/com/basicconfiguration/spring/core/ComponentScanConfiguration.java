package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * Spring akan melakukan Scaning kepada package ini dan jikalau
 * Spring mememukan class yang di annotasi sebagai @Configuration
 * maka class tersebut akan di Import dan jikalau Spring menemukan
 * sub package maka semua class didalam sun package tersebut akan 
 * ikut di import
 */
@ComponentScan(basePackages = {
    "com.basicconfiguration.spring.core.examplecomponentscan"
})
public class ComponentScanConfiguration { }
