package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.factory.PaymentGatewayFactoryBean;
import com.basicconfiguration.spring.core.factory.PaymentGetwayClientFactoryBean;

@Configuration
@Import({
   PaymentGetwayClientFactoryBean.class, 
   PaymentGatewayFactoryBean.class
})
public class FactoryConfiguration { }
