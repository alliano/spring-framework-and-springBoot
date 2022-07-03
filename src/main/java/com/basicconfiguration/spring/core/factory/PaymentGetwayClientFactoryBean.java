package com.basicconfiguration.spring.core.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.client.paymentGetwayClient;

/**
 * Factory bean
 * kadang ada kasus diman sebuah class misal bukan millik kita, misal class third party liberary 
 * sehingga agak sulit jika kita harus menambahkan annotation pada class tersebut
 * pada kasus seperti ini, cara terbaik untuk membuat bean nya dalah dengan menggunakan 
 * @Bean method
 * atau di spring kita juga bisa menggunakan @Component nanmun kita perlu wrap dalam class
 * FactoryBean 
 */


@Component(value = "paymenyGetway")
public class PaymentGetwayClientFactoryBean implements FactoryBean<paymentGetwayClient>{

   @Override
   public paymentGetwayClient getObject() throws Exception {
      paymentGetwayClient client = new paymentGetwayClient();
      client.setEndpoint("http://localhost/entity/Graphql");
      client.setPrivateKey("private");
      client.setPublicKey("public");
      return client;
   }

   @Override
   public Class<?> getObjectType() {
      return paymentGetwayClient.class;
   }
   
}
