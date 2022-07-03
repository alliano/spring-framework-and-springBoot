package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.MultipleFoo;
import com.basicconfiguration.spring.core.repository.CategoryRepository;
import com.basicconfiguration.spring.core.repository.CustomerRepository;
import com.basicconfiguration.spring.core.repository.ProductRepository;
import com.basicconfiguration.spring.core.service.CategoryService;
import com.basicconfiguration.spring.core.service.CustomerService;
import com.basicconfiguration.spring.core.service.ProductService;

public class ComponentconfigurationTest {
   
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
   }

   @Test
   void testComponent(){
      ProductService productService1 = this.context.getBean("productService",ProductService.class);
      ProductService productService2 = this.context.getBean("productService",ProductService.class);

      Assertions.assertNotNull(productService1);
      Assertions.assertNotNull(productService2);
   }

   @Test
   void productRepoTest(){
      ProductService productService = this.context.getBean(ProductService.class);
      ProductRepository productRepository = this.context.getBean(ProductRepository.class);

      Assertions.assertSame(productRepository,productService.getProductRepository());
   }

   @Test
   void testDependencyInjectionBySetter(){
      CategoryRepository category  = this.context.getBean(CategoryRepository.class);
      CategoryService service = this.context.getBean(CategoryService.class);

      Assertions.assertSame(category, service.getRepository());
   }

   @Test
   void dependencyInjectionTest(){
      CustomerService service = this.context.getBean(CustomerService.class);
      
      CustomerRepository normalCustomerRepo = this.context.getBean("normalCustomerRepository", CustomerRepository.class);
      CustomerRepository premiumCustomerRepo = this.context.getBean("premiumCustomerRepository", CustomerRepository.class);

      Assertions.assertSame(normalCustomerRepo, service.getNormalCustomerRepository());
      Assertions.assertSame(premiumCustomerRepo, service.getPremiumCustomerRepository());
   }

   @Test
   void objectProviderTest(){
      MultipleFoo multipleFoo = this.context.getBean(MultipleFoo.class);

      Assertions.assertEquals(3, multipleFoo.getFoo().size());
   }
}
