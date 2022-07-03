package com.basicconfiguration.spring.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basicconfiguration.spring.core.repository.CustomerRepository;

@Configuration
public class CustomerConfiguration {
   
   @Bean()
   public CustomerRepository normalCustomerRepository(){
      return new CustomerRepository();
   }

   @Bean()
   public CustomerRepository premiumCustomerRepository(){
      return new CustomerRepository();
   }

}
