package com.basicconfiguration.spring.core.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.repository.CustomerRepository;

@Component
public class CustomerService {
   
   private CustomerRepository normalCustomerRepository;

   private CustomerRepository premiumCustomerRepository;

   public CustomerService(@Qualifier("normalCustomerRepository") CustomerRepository normaCustomerRepository, @Qualifier("premiumCustomerRepository") CustomerRepository premiuCustomerRepository) {
      this.normalCustomerRepository = normaCustomerRepository;
      this.premiumCustomerRepository = premiuCustomerRepository;
   }

   public CustomerRepository getNormalCustomerRepository() {
      return this.normalCustomerRepository;
   }

   public CustomerRepository getPremCustomerRepository() {
      return this.premiumCustomerRepository;
   }

   public CustomerRepository getPremiumCustomerRepository() {
      return premiumCustomerRepository;
   }
}
