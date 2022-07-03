package com.basicconfiguration.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.repository.CustomerRepository;

@Component
public class CustomerService {
   
   /**
    * Qualifier 
    * Seperti yang sudah di jelaskan di awal, jika terdapat bean dengan tipe dengan tipe data yang sama
    * lebih dari 1, maka secara otomatis spring akan bingung memilih bean mana yang akan digunakan
    * Kita perlu memilh salah 1 menjadi Primary, yang secara optomatis dipilih oleh spring 
    * namun jika kita ingin memilih bean secara manual kita juga bisa menggunakan annotation @Qualifier
    * kita bisa tambahkan @Qualifier di constructor parameter, atau di setter method atau di field
    * cotoh menggunakan @Qualifier di field:
    */

   @Autowired
   @Qualifier(value = "normalCustomerRepository")
   private CustomerRepository normalCustomerRepository;

   @Autowired
   @Qualifier(value = "premiumCustomerRepository")
   private CustomerRepository premiumCustomerRepository;

   public void setNormalCustomerRepository(CustomerRepository normalCustomerRepository) {
      this.normalCustomerRepository = normalCustomerRepository;
   }
   public CustomerRepository getNormalCustomerRepository() {
      return normalCustomerRepository;
   }
   public void setPremiumCustomerRepository(CustomerRepository premiumCustomerRepository) {
      this.premiumCustomerRepository = premiumCustomerRepository;
   }
   public CustomerRepository getPremiumCustomerRepository() {
      return premiumCustomerRepository;
   }
}
