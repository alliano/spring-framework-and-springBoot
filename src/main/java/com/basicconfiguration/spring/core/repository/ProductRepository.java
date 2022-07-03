package com.basicconfiguration.spring.core.repository;

import org.springframework.stereotype.Component;

/**
 * dependency injection
 * 
 * untuk melakukan dependency injection di @Bean, kita bisa menambah paramater
 * di method nya 
 * secara otomatis spring akan memilih bean yang cocok untuk parameter tersebut
 * jika kita menggunakan @Component ada beberapa cara untuk melakukan dependency injection
 * 
 * 
 * constructor-based Dependency Injection
 * pertama kita bisa menambahakan dempendency injection di @Component adalah menggunakan
 * constructor parameter
 * kita bisa menambahakan constructor yang memiliki parameter jika membutuhkan bean lain
 * secara otomatis spring akan mencarikan bean tersebut, dan ketika membuat bean @Component
 * springa akan menggunakan bean yang dibutuhkan di cnstructor
 * constructor-based Dependency Injection hanya mendukung 1 constructor jadi pastikan hanya membuat 
 * 1 constructor
 * 
 * Exapmle ada di file ProductService.java
 * 
 * Multiple constructor
 * seperti di awal di sebutkan bahwa spring hanya mendukung satu constructor untuk Dependency
 * Injectionya 
 * namaun bagai manan jika terdapat multiple constructor
 * jika akita menemukan kasus seperti ini, kita harus memanadai constructor mana yang 
 * akan digunakan oleh spring 
 * caranya kita bisa menggunakan annotation @AutoWired
 * 
 * Example ada di file ProductService.java
 */
@Component
public class ProductRepository {
   
}
