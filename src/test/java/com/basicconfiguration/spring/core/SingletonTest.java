package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest{

   @Test
   void TestSingleTon(){

      /**
       * karna constructor class Databse itu privat maka kita 
       * menginstansiasinya menggunakan method getInstance() 
       * yang telah di buat di dalam class class tersebut 
       */
      Database databse1 = Database.getInstancDatabase();
      Database databse2 = Database.getInstancDatabase();


      /** 
       * sekarang kita cek apakah object database1 dan database2 sama
       * karna singleton itu salah satu design pattren 
       * yang mana proses pembuatan object nya hanya 1x
       */
      Assertions.assertSame(databse1, databse2);
   }
}