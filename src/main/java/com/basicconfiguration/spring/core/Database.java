package com.basicconfiguration.spring.core;

/**
 * spring sendiri menggunkaan singleton
 * singleton adalah salah satu design pattren untuk poembuatan Object
 * yang mana object tersebut hanya di buat 1x 
 * jkalau object tersebut sudah ada makan object tidak di buat lagi 
 */
public class Database {
   
   /**
    * ada bnayak cara untuk membuat singleton di java 
    * cara ayng paling sering di gunakan adalah dengan membuat class
    * yang berisikan static method untuk membuat dirinya sendiri 
    * dan membuat private constructor agar tidak bisa di aksed dari luar
    * dan tidak bisa di instansiasi 
    * contoh :
    */
    public static Database database;

    public static Database getInstancDatabase(){
       if (database == null) database = new Database();
       return database; 
    }

    private Database(){

    }
}
