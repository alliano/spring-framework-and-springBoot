package com.basicconfiguration.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.repository.ProductRepository;





@Component(value = "productService")
public class ProductService {
  
   private ProductRepository productRepository;

   /**
    * 1 constructor tampa @Autowired adalah contoh untuk constructor-based Dependency Injection
    * untuk 2 constructor dan 1 parameter padaconstructor dan constructor di annotasi 
    * dengan @AutoWired itu contoh untuk Multiple constructor untuk dependency injection
    * @param productRepository
    */
   
   @Autowired
   public ProductService(ProductRepository productRepository){
      this.productRepository = productRepository;
   }


   public ProductService(ProductRepository productRepository,String name){
      this.productRepository = productRepository;
   }

   public ProductRepository getProductRepository() {
      return this.productRepository;
   }
   
}
