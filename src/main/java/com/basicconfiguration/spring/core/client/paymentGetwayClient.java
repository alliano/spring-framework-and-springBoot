package com.basicconfiguration.spring.core.client;

/**
 * ini sebagai contoh class third party liberary untuk contoh BeanFactory
 */

public class paymentGetwayClient {

   private String endpoint;

   private String privateKey;

   private String publicKey;

   public String getEndpoint() {
      return endpoint;
   }
   public void setEndpoint(String endpoint) {
      this.endpoint = endpoint;
   }
   public String getPrivateKey() {
      return privateKey;
   }
   public void setPrivateKey(String privateKey) {
      this.privateKey = privateKey;
   }
   public String getPublicKey() {
      return publicKey;
   }
   public void setPublicKey(String publicKey) {
      this.publicKey = publicKey;
   }
}
