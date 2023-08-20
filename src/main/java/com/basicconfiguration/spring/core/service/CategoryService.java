package com.basicconfiguration.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.repository.CategoryRepository;

/**
 * setter-based Dependency injection
 * 
 * selain menggunakan constructor parameter, kita jga bisa menggunakan setter method 
 * jika inggin melakukan dependency injection 
 * namun kusus untuk setter method, kita perlu menambahkan annotation @AutoWired 
 * pada setter method nya 
 * secata otomatis sprimg akan mencari bean yang dibutuhkan di setter method yang 
 * dimiliki annotation @AutoWired 
 * setter-based DI juga bisa digabung dengan Constructor-based DI
 */

@Component
public class CategoryService {
   
   private CategoryRepository repository;

   // Constructor Injection
   public CategoryService(CategoryRepository categoryRepository) {
      this.repository = categoryRepository;
   }

   public CategoryRepository getRepository() {
      return repository;
   }

   // Setter Injection
   @Autowired
   public void setRepository(CategoryRepository repository) {
      this.repository = repository;
   }
}
