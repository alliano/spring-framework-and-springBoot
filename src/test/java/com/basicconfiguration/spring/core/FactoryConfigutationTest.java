package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.client.PaymetGateway;
import com.basicconfiguration.spring.core.client.paymentGetwayClient;

public class FactoryConfigutationTest {
   
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(FactoryConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void FactoryBean(){
      paymentGetwayClient getwayClient = this.context.getBean(paymentGetwayClient.class);
      
      Assertions.assertSame("http://localhost/entity/Graphql", getwayClient.getEndpoint());
      Assertions.assertSame("private", getwayClient.getPrivateKey());
      Assertions.assertSame("public", getwayClient.getPublicKey());
   }

   @Test
   public void testFactoryBean() {
      PaymetGateway paymentGateway = this.context.getBean(PaymetGateway.class);
      Assertions.assertNotNull(paymentGateway);
      Assertions.assertSame("https://examplePaymentGateway.com/req", paymentGateway.getEndpoint());
      Assertions.assertSame("private_key", paymentGateway.getPrivateKey());
      Assertions.assertSame("public_key", paymentGateway.getPublicKey());
   }
}
