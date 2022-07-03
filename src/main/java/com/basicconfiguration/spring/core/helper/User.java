package com.basicconfiguration.spring.core.helper;

public class User {
   
   private String userName;

   public User(String userName) {
      this.userName = userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }
   public String getUserName() {
      return userName;
   }
}
