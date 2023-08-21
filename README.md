# Apa itu Sring framework
spring framework adalah framework atau krangka kerja yang paling populer di Java programming  
spring framework dibuat pada tahun 2003 oleh Road johnson, yang dibuat sebagai alternativ Jakarta Enterprise(JEE)  
Spring framework populer karena sangat ringan dan mudah digunakan dibandingkan Jakarta Enterprise(JEE)
untuk lebih detailnya bisa kunjungi langsung di situs resmi [spring.io](https://spring.io)

# Apa itu Sring Boot
spring boot adalah framewrk untuk mempermudah pembuatan applikasi spring framework  
untuk menggunakan spring framework itu sangatlah rumit bagi pemula yang baru terjuan di bahasa pemograman Java.  
Spring boot hadir dengan menjadikan kompleksitas Spring framework ditangani oleh Spring boot, sehingga dapat mempermudah dan mempercepat pembuatan spring framework tampa melakukan konfigurasi apapun.

# Ekosistem Spring
Spring teknologi mempunyai ekosistem yang sangat besar  
Spring itu sendiri dibuat bukan untuk menggantikan framework existing misalnya seperti bean validation dan sebagaiya.  
melainkan spring framework hadir untuk mempermudah dan menggabungkan framework-framework existing sehingga terintregasi dengan baik, misalnya dengan JPA, Bean validation, Servlet, dan sebgainya..  
selain itu Spring juga telah terintregasi dengan baik dan setabil dengan teknologi diluar ekosistem java, misalnya Postgresql, mongoDb, Consul, Casandra dan masih banyak lagi..

# Membuat project 
[https://start.spring.io](https://start.spring.io)

# Inversion Of Control
Inversion Of control (IOC) adalah prinsip dalam pembuatan prengkat lunak, yangmana kita akan memindahkan kontrol untuk object atau kode program kedalam container framework  
Saat pembuatan applikasi sering kali kita membuat object dan sebagainya secara manual, dengan prinsip IOC ini kita akan menyerahkan banyak pekerjaan kepada container IOC  
contauiner IOC ini memiliki kontrol kepada program kita, menejemen object pada program kita dan juga melakukan abstraction kepada program kita.  

<!-- # Diagram Inversion Of Control -->

# Application context 
ApllicationContext adalah sebuah interface atau kontrak representasi dari container IOC di spring framework  
ApplicationContext merupakan inti dari spring Framework  
ApplicationContext banyak sekali class inmplementasinya, secara garis besar terbagi menjadi 2 yaitu :
   * XML 
   * Annotation  

Untuk sekarang ini sangat direkomendasikan untuk menggunakan annotation  
[ApplicationContext](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html)

# @Configuration
Untuk membuat ApplicationContext menggunakan Annotation, hal pertama yang harus dilakukan adalah membuat class  
setelah itu, kita berikan annotasi @Configuration pada class tersebut.  

``` java
package com.basicconfiguration.spring.core;
import org.springframework.context.annotation.Configuration;

/**
 * untuk membuat configuration spring kita harus menamabhkan 
 * annotasi @Configuration
 */
@Configuration
public class HelloWolrdConfiguration {

}
```

# Membuat ApplicationContext
setelah membuat class configuration, setelah itu kita bisa membuat class AnnotationConfigApplicationContext untuk membuat ApplicationContext (untuk mengetahui atau berintraksi dengan spring container Ioc).

``` java
public class ApplicationContextTest {

   /**
    * ktia bisa meng test application context dengan cara polimophisem 
    * class AnnotationConfigApplicationContext
    */
   @Test
   void testApplicationContext(){
      /**
       * membuat ApplicationContext, dengan membuat ApplicationContext kita dapt berintraksi dengan spring IOC
       * 
       * AnnotationConfigApplicationContext() => digunakan untuk membuat ApplicationContext dengan 
       * kofigurasi annotation based
       */
      ApplicationContext context = new AnnotationConfigApplicationContext(HelloWolrdConfiguration.class);
      Assertions.assertNotNull(context);
   }  
}
```

# Singleton
singleton merupakan salhsatu design paterens untuk pembuatan object, yang mana suatu object dibuat hanya 1x, dan jikalau object tersebut di inisiasi atau dibuat ulang maka object tersebut akan mengembalikan object yang sama.  
By default pembuatan object di spirng container ioc itu menggunakan design patteren
[Singleton](https://refactoring.guru/design-patterns/singleton)

``` java
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
```
``` java
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
```

# Bean
saat sebuah object kita masukan kedalam spring container ioc, maka kita sebut object tersebut sebgai Bean.  
Secara default bean di spring container ioc itu singleton.

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Foo;
/**
 * Bean adalah suatu object yang di masukan di dala ioc atau configuration
 * saat suatu object kita masukan ke dalam container ioc maka kita sebut
 * object tersebut adalah Bean
 * secara default Bean adalah SingleTon artinya jika kita mengakses bean yang sama 
 * maka akan di kembalikan Bean yang sama juga
 */
@Configuration
public class BeanConfiguration {

    /**
     * untuk membaut bean tambahkan anotasi @Bean di atas method
     * contoh bean
     */

   @Bean
   public Foo foo(){
      return new Foo();
   }
    /**
     * setelah membaut bean secara otomatis semua object di manatge oleh ApplicationContext
     * untuk mengakses nya kita bisa menggunakan method getBean milik ApplicationContext
     */
}
```
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;

public class BeanTest {

   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
   }

   @Test
   void getBean(){
      /**
       * saat kita memanggil bean nya 2x ini kan membuat object hanya 1x
       * jadi sebelum Foo di panggil itu udah di buat terlebihdahulu 
       * dan saat kita panggil maka akan mereturn object yang sama dan tidak meng create object baru
       */
      Foo foo1 = context.getBean(Foo.class);
      Foo foo2 = context.getBean(Foo.class);

      /** 
       * untuk membuktikan bahawa ini sama kita bisa cek 
       */
      Assertions.assertSame(foo1, foo2);
   }
}
```

# Duplicate Bean
Pada spring container ioc kita dapat meregistrasikan beberapa bean dengan tipe data yang sama  
dengan ketentuan bean tersebut harus menggunakan nama yang berbeda  
dan saat mengakses bean nya, kita wajib menyebutkan nama bean nya agar spring container ioc tidak bingug harus menggambil bean yang mana.

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class DuplicateConfiguration {

   @Bean()
   public Foo foo1(){
      return new Foo();
   }

   @Bean
   public Foo foo2(){
      return new Foo();
   }
}
```
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;


public class DuplicateBeanTest {

   private ApplicationContext applicationContext;

   @BeforeEach
   void setup() {
      this.applicationContext = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
   }

   @Test
   void duplicateTestBean(){
      /**
       * ini akan error karna spring nya akan tidakdapat menemukan Bean dengan nama Foo
       * karna spring mnya mendapatkan 2 Bean jadi Spring nya bingung Foo yang mna yang di maksud karna
       * expetasi kita ingin mendapat kan 1 Bean foo namun kita mendapatkan 2 Bean foo
       *
       */
      Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> applicationContext.getBean(Foo.class));
   }

   @Test
   void test(){
      /**
       * jikalau kita memiliki 2 Tipe bean yang sama maka jikalau kita mauu memanggilnya
       * harus kita panggil nama dan tipe Bean nya
       */
      Foo foo1 = this.applicationContext.getBean("foo1",Foo.class);
      Foo foo2 = this.applicationContext.getBean("foo2",Foo.class);

      /**
       * ini kikalau kita panggil berkali2 object Foo1 atau Foo2 tetap
       * hanya dibuat 1x
       * karna itu memmang perilaku singleton
       */
      Assertions.assertNotNull(foo1);
      Assertions.assertNotNull(foo2);

      Assertions.assertNotSame(foo1, foo2);
   }
}
```

# Primary Bean
jika kita memiliki duplikat bean, kita bisa menentukan salahsatu sebagai primary.  
dengan demikian secara saat kita mengakses bean berdasarkan class nya atau mengakses bean dengan tidak menyebutkan nama bean nya maka secara otomatis bean yang akan dipilih bean primary nya  
untuk menjadikan bean menjadi primary kita dapat menambahkan annotasi @Primary
``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class PrimaryBeanConfiguration {

   /**
    * untuk mengatasi duplicate Bean sebenarnya kita bisa mengatasinya
    * dengan menambahkan annotasi @Primary di salah satu @bean 
    * ini artinya nanti jikalau bean itu di panggil tampa memanggil namanya jga 
    * maka @bean yang di anotasi sebagai @Primary akan di panggil 
    * jadi spring nya tidak bingung
    * Contoh :
    */
   @Bean @Primary
   public Foo foo1(){
      return new Foo();
   }

   @Bean
   public Foo foo2(){
      return new Foo();
   }
}
```
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;

public class PrimaryBeanConfigurationTet {

   public ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(PrimaryBeanConfiguration.class);
   }
   
   @Test
   void testPrimary(){
      /**
       * ini akan tidak error karna ada salah satu bean yang telah di anotasi sebagai
       * @primary jadi jikalau kita memanngil bean tampa kita panggil namanya 
       * itu secara default akan memanggil bean yang di anotasi dengan @Primary
       * disini saya menganotasi foo1 sebagai @Primary
       */
      Foo foo1 = context.getBean(Foo.class);
      //kita juga bsa memanggil dengan nama bean nya
      Foo foo = context.getBean("foo1", Foo.class);
      Foo foo2 = context.getBean("foo2", Foo.class);
      
      Assertions.assertNotNull(foo1);
      Assertions.assertNotNull(foo2);

      Assertions.assertNotSame(foo1, foo2);
      Assertions.assertNotSame(foo, foo2);
      Assertions.assertSame(foo1, foo1);
   }
}
```
# Mengubah Nama Bean
saat kita membuat bean, nama bean diambil dari nama method, pada kasus tertentu kita tidak ingin nama bean dari nama method.  
kita bisa menamai bean sesuai dengan keinginan kita dengan memanfaatkan method value() yang terdapat pada annotasi @Bean
``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class BeanNameConfiguration {

   /*
    * secara default nama bean di ambil dari nama method 
    * tetapi kadang kita tidak ingin menggunakan nama method untuk menjadi nama 
    * bean 
    * jikalau project sudah sangat besar kadang kita bisa memiliki nama method bean
    * yang sama walaupun isinya berbeda dan di spring framework itu
    * nama bean tidakboleh sama 
    * nama bean harus lah Unique
    * untuk membuat nama bean kita bisa menambahkan parameter name="" atau value=""
    * didalam parameter annotasi @bean 
    * contoh : @bean(name = "ex1")
    */
   @Primary
   @Bean(value = "foo_first")
   public Foo foo1(){
      return new Foo();
   }
   @Bean(value = "foo_second")
   public Foo foo2(){
      return new Foo();
   }
}
```
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.Foo;

public class BeanNameconfigTest {
   
   public ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
   }
   @Test
   void testName(){
      Foo foo1 = this.context.getBean("foo_first",Foo.class );
      Foo foo2 = this.context.getBean("foo_second",Foo.class );
      Foo fooFirst = this.context.getBean(Foo.class );

      Assertions.assertSame(foo1, fooFirst);
      Assertions.assertNotSame(foo1, foo2);;
      Assertions.assertNotSame(fooFirst, foo2);;
   }
}
```

# Dependency Injecttion (DI)
Dependency Injection adalah teknik membuat object yang mana object tersebut ketergantugan dengan object lain, atau biasa disebut dependencies.  
Cara kerja Dependency injection yaitu dengan memasukan object yang dibutuhkan kedalam object, hal tersebut biasa disebut dengan teknik Injection.  
Spring container ioc merupakan container ioc yang sejak awal menerapkan taknik Dependency Injection.  

# Tampa Dependency Injection
Saat kita membuat software, sebenarnya kita tidak menggunakan konsep Dependency Injetion itu tetap bisa.  
Namun ketika relasi antar dependencies sangat kompleks, maka akan rumit sekali jika kita lakukan secara manual.  
oleh karna itu hadirnya spirng container Ioc dengan menerapkan konsep Dependency Injection sanga membantu.  
  
Berikut ini adalh contoh kode yang tidak memanfaatkan fitur Dependency Injection milik Spring container ioc  
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

public class DependencyInjectionTest{

   /**
    * ini adalah contoh dependency injection secara manual
    */

   @Test
   void testNoDependencyInjection(){
      Foo foo = new Foo();
      Bar bar = new Bar();

      FooBar fooBar = new FooBar(foo,bar);

      Assertions.assertSame(foo, fooBar.getFoo());
      Assertions.assertSame(bar, fooBar.getBar());
   }
}
```

# Spring Dependency Injection
Spring sangat terkenal dengan framework untuk Dependency Injection  
Saat kita membuat method untuk Bean, kita bisa menambahkan parameter  
Dan secara otomatis Spring akan mencarikan bean lain yang sesuai dengan tipe parameter tersebut  
jikalau tidak ada bean yang cocok dengan parameter tersebut, maka secara otomatis akan error  
Dan jikalau terdapat bean lebih dari 1, maka akan terjadi error, kecuali terdapat primary bean.
``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

@Configuration
public class DependencyInjectionConfigure {
   
   @Bean(value = "foo")
   public Foo foo(){
      return new Foo();
   }

   @Bean(value = "bar")
   public Bar bar(){
      return new Bar();
   }
   /**
    * untuk dependency injction secara otomatis kita bisa set seperti ini
    * kita cukup set sebagai parameter saja disini
    * dengan ketentuan Obejct parameter tersebut telah memiliki Bean nya
    * dalam konteks ini Bean pada parameter nya telah dibuatkan pada statement diatas
    */
    @Bean(value = "fooBar")
    public FooBar fooBar(Foo foo,Bar bar){
       return new FooBar(foo,bar);
    }
}
```
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

public class DependencyInjectionConfigureTest {
   
   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(DependencyInjectionConfigure.class);
   }
   
   // untuk dependency injection secara otomatis kita bila lakukan seperti ini 
   @Test
   void tesDependen(){
      // kita tidak perlu menambahkan keyword new lagi unutuk inisiasi Foo dan Bar
      Foo foo = this.context.getBean("foo",Foo.class);
      Bar bar = this.context.getBean("bar",Bar.class);
      FooBar fooBar = this.context.getBean(FooBar.class);

      Assertions.assertSame(foo, fooBar.getFoo());
      Assertions.assertSame(bar, fooBar.getBar());
   }
}
```

# Memilih Dependency
Saat membuat bean dengan ketergantungan dengan object lain(Dependency Injection) terkadang kita ingin memilih dependency secara explisit(secara spesifik).  
Hal tersebut dapat kita lakukan dengan menggunakan annotation @Qualifier(value = "nama bean") pada parameter methodnya.  
Annotation @Qualifier ini dapat kita gunakan di Level Method Parameter, Field, dan Constructor Parameter

``` java
package com.basicconfiguration.spring.core;
package com.basicconfiguration.spring.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ScopeConfiguration {

   /**
    * scope merupakan strategy cara sebuah object di buat secara default object di spring dibuat 
    * dengan singleton artinya hanya sekali ketika kita akses/butuhkan dan jika kita akses ke 2x 
    * nya maka akan menggembalikan object yang sama
    * namaun kita jga bisa menggubah scope bean yang kita mau di spring 
    * untuk mengubah sebuah scope di bean kita bisa mengguakan annotasi @Scope(value = "nama secope nya") 
    * jika kita tidak tambahkan annotasi @Scope() by default spring akan menggunakan secope singleton
    */

   @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
   @Bean(value = "fooScope")
   public Foo foo(){
      log.info("===>Foo Scope has created<===");
      return new Foo();
   }
}
```

``` java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

@Configuration
public class ChooseDependen {
   @Primary
   @Bean(value = "fooFrist")
   public Foo fooFrist(){
      return new Foo();
   }
   
   @Bean(value = "fooSecond")
   public Foo fooSecond(){
      return new Foo();
   }
   
   @Bean(value = "bar")
   public Bar bar(){
      return new Bar();
   }
   
   /**
    * kadang saat kita menggunakan Di, kita inigin memillih Object mana yang mau kita gunakan
    * saat terdapat duplicate bean dengan tipe data yang sama, secara otomaatis spring 
    * akan memilih bean yang di anotasi sebagai @primary namun kita jga bisa memillih secara manual 
    * cara nya kita bisa menambahkan annotasi @Qualifier(name = "nama bean nya") pada parameter di
    * method nya contoh : 
    */
    @Bean(value = "fooBar")
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo,Bar bar){
      return new FooBar( foo, bar);
    }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

public class ChooseDependenTest {
   
   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ChooseDependen.class);
   }

   @Test
   void chooseDependen(){
      Foo fooSecond = this.context.getBean("fooSecond", Foo.class);
      Bar bar = this.context.getBean(Bar.class);
      FooBar fooBar = context.getBean("fooBar", FooBar.class);

      Assertions.assertSame(fooSecond, fooBar.getFoo());
      Assertions.assertSame(bar, fooBar.getBar());
   }
}
```

# Circular Dependencies
Saat implementasikan konsep Dependency Injection, harus berhati-hati dengan Circular Depency  
Circular Dependency adalah sebuah kasus lingkaran dependency terjadi, misalnya Bean A dependen ke bean B, dan bean B dependen ke bean C, dan bean C dependen ke bean A.  
Saat terjadi Circular Dependencies, maka spring akan secara otomatis mendeteksinya, dan akan mengeluarkan Exception Circular Dependency(Terjadi Error).

``` java
package com.basicconfiguration.spring.core.helper.cilcularDependency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class CyclicA {

   private CyclicB cyclicB;

}
```

``` java
package com.basicconfiguration.spring.core.helper.cilcularDependency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter @Getter @NoArgsConstructor
public class CyclicB {
   
   private CyclicC cyclicC;

}
```

``` java
package com.basicconfiguration.spring.core.helper.cilcularDependency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter @AllArgsConstructor
public class CyclicC {
   
   private CyclicA cyclicA;
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.cilcularDependency.CyclicA;
import com.basicconfiguration.spring.core.helper.cilcularDependency.CyclicB;
import com.basicconfiguration.spring.core.helper.cilcularDependency.CyclicC;

@Configuration
public class CyclicConfiguration {

   @Bean(value = "cyclicA")
   public CyclicA cyclicA(CyclicB cyclicB){
      return new CyclicA(cyclicB);
   }

   @Bean(value = "cyclicB")
   public CyclicB cyclicB(CyclicC cyclicC){
      return new CyclicB(cyclicC);
   }

   @Bean(value = "cyclicC")
   public CyclicC cyclicC(CyclicA cyclicA){
      return new CyclicC(cyclicA);
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyclicConfigureationTest {
   
   @Test
   void tesCyclic(){
   
      /**
       * disini akan berhasil karna object ini terjadi error circular
       * yang mana object tersebut salng terhuketergantungan sesama object lain dan ketergantungan tersebut membentuk 
       * lingkaran yang bisasa disebut cycle 
       * cnth :
       * objA butuh objB objB butuh objC objC butuh objA
       */
      Assertions.assertThrows(UnsatisfiedDependencyException.class, () -> new AnnotationConfigApplicationContext(CyclicConfiguration.class));
   }
}
```

# Depends On Annotation
Saat kita membuat bean yang ketergantungan dengan bean lain, maka bean tersebut akan dibuat setelah bean yang dibutuhkan dibuat. 
pada kasus tertentu terkadang kita ingin sebuah bean dibuat setelah bean lain dibuat.  
Untuk kasus sepeperti itu kita dapat memanfaatkan annotasi @DependsOn(value = {"bean_name"}).  
Maka secara otomatis Spring container akan membuatkan bean yang terdapat pada annotasi @DependsOn terlebih dahulu.

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.extern.slf4j.Slf4j;

@Configuration @Slf4j
public class DependsOnConfiguration {
    /**
     * bean ini kan dibuat setelah bean barDependensOn dibuat
     */
   @DependsOn({"barDependsOn"})
   @Bean(value = "fooDependsOn")
   public Foo foo(){    
     log.info("===========creating Foo============");
      return new Foo();
   }

   @Bean(value = "barDependsOn")
   public Bar bar(){
      log.info("========Creating bar=========");
      return new Bar();
   }
}
```
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;

public class DepensOnConfigurationTest {
   private ApplicationContext context;
   
   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
   }

   @Test
   void testDepenOn(){
      Bar bar = context.getBean("barDependsOn",Bar.class);
      Assertions.assertNotNull(bar);
   }
}
```

# Lazy bean
Pembuatan Bean di Spring itu dilakukan saat applikasi spring pertamakali dijalankan, maka dari itu terkadang jikalau banyak sekali bean yang harus dibuat biasaya membutuhkan waktu start yang agak lama dikit :v  
Namun jikalau kita ingin pembuatan bean nya itu saat Bean tersebut dibutuhkan/diakses, kita dapat menambahkan annotasi @Lazy pada method yang akan membuat bean tersebut.  
``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LazyBeanConfiguration {

   // method ini akan membuat bean Foo saat bean tersebut dibutuhkan atau di akses
   @Lazy
   @DependsOn("barLazy")
   @Bean(value = "fooLazy")
   public Foo foo(){
      log.info("====creating fooLazy====");
      return new Foo();
   }

   @Bean(value = "barLazy")
   public Bar bar(){
      log.info("====creating barLazy====");
      return new Bar();
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;

public class LazyBeanConfigurationTest {

   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(LazyBeanConfiguration.class);
   }

   @Test
   void tetLazyBean(){
      Bar bar = this.context.getBean("bar_",Bar.class);
      Assertions.assertNotNull(bar);

      /**
       * jika kita tidak memanggil bean fooLazy maka bean fooLazy tidak akan di buat
       * karna bean fooLazy telah di annotasi sebagai @Lazy 
       * jadi bean tersebut akan di buat kalaui bean tersebut di butuhkan
       * 
       * kalo nga percaya coba komentari statement dibawah ini dan jalankan Unit test nya :v
       */
      
      Foo foo = this.context.getBean("fooLazy",Foo.class);
      Assertions.assertNotNull(foo);
   }
}
```

# Scope
Scope merupakan annotasi untuk menentukan cara sebuah object dibuat.  
secara default saat kita membuat bean, Spring container Ioc akan menggunakan strategi singleton, maksudnya Object dibuat hanya 1x, dan ketika bean tersebut beberapa kali diakses maka akan mengembalikan object yang sama.  
pada kasus tertentu terkadang kita ingin mengubah strategi pembuatan Object nya.  
Untuk mengubah nya kita bisa menggunakan annotation [@Scope(value = "namaStrategy")](https://www.baeldung.com/spring-bean-scopes)

Spring memiliki beberap Strategy pembuatan Object, berikut ini adalah Strategy yang tersedia dan penjelasanya :
|  Strategy    |  Keterangan                                                            |
|--------------|------------------------------------------------------------------------|
|  singleton   |  Object bean hanya dibuat 1x dalam Spring container ioc (default)      |
|  prototype   |  Object akan selalu dibuat ketika bean diakses                         |
|  request     |  Object dibuat baru per http request(Hanya untuk applikasi Web)        |
|  session     |  Object dibuat baru per http session (Hanya untuk applikasi Web)       |
|  application |  Object dibuat per Servletcontext(Hanya untuk applikasi Web)           |
|  websocket   |  Object dibuat per session http socket(Hanya untuk applikasi WebSocket)|  
  


``` java
package com.basicconfiguration.spring.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ScopeConfiguration {

   /**
    * scope merupakan strategy cara sebuah object di buat secara default object di spring dibuat 
    * dengan singleton artinya hanya sekali ketika kita akses/butuhkan dan jika kita akses ke 2x 
    * nya maka akan menggembalikan object yang sama
    * namaun kita jga bisa menggubah scope bean yang kita mau di spring 
    * untuk mengubah sebuah scope di bean kita bisa mengguakan annotasi @Scope(value = "nama secope nya") 
    * jika kita tidak tambahkan annotasi @Scope() by default spring akan menggunakan secope singleton
    */

   @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
   @Bean(value = "fooScope")
   public Foo foo(){
      log.info("===>Foo Scope has created<===");
      return new Foo();
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;

public class ScopConfigurationTest {
   
   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
   }

   @Test
   void scopeTest(){
      Foo foo1 = this.context.getBean("fooScope",Foo.class);
      Foo foo2 = this.context.getBean("fooScope",Foo.class);
      Foo foo3 = this.context.getBean("fooScope",Foo.class);

      /**
       * ini akan mengembalikan 3 object yang berbeda karna kita telah mengubah
       * Scope nya menjadi prototype
       */
      Assertions.assertNotSame(foo1, foo2);
      Assertions.assertNotSame(foo1, foo3);
      Assertions.assertNotSame(foo2, foo3);
   }
}
```

# Custom Scope
Kita juga bisa membuat scope kita sendiri, dengan cara mengimplementasikan interface [Scope](https://docs.spring.io/docs/current/javadocs-api/org/springframework/beans/factory/config/Scope.html)  
setelah kita mengimplementasikanya, langkah selanjutnya adalah meregistrasikanya dengan cara membuat bean [CustomScopeConfigurer](https://docs.spring.io/docs/current/javadocs-api/org/springframework/beans/factory/config/CustomScopeConfigurer.html)  

membuat custom scope dengan mengimplementasikan interface Scope
``` java
package com.basicconfiguration.spring.core.helper.scope;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class DoubletonScope implements Scope {

   private List<Object> objects = new ArrayList<Object>(2);
   private Long counter = -1L;

   /**
    * method ini memiliki 2 parameter yang pertama adalah parameter untuk nama object nya
    * ke 2 untuk object nya
    * properti object utuk menyimpan object kedalam arrayList 
    * properti count untuk menghitung berapa kali object dipanggil
    * jika jumlah object itu sama dengan 2 maka counter akan di modulus 2 maka hasilnya 0
    * dan akan mengembalikan object dengan index ke 0 
    * dan jika object nya tidak sama dengan 2 maka object akan di tambahkan 1 object
    */
   @Override
   public Object get(String name, ObjectFactory<?> objectFactory) {
      counter++;
      if(objects.size() == 2) {
         int index = (int)(counter % 2);
         return objects.get(index);
      }
      else{
          Object object = objectFactory.getObject();
          objects.add(object);
          return object;
      }
   }

   @Override
   public Object remove(String name) {
      if(!objects.isEmpty())return this.objects.remove(0);
      return null;
   }

   @Override
   public void registerDestructionCallback(String name, Runnable callback) {}

   @Override
   public Object resolveContextualObject(String key) {
      return null;
   }

   @Override
   public String getConversationId() {
      return null;
   }
}
```

meregistrasikan custom scope yang basusan dibuat
``` java
package com.basicconfiguration.spring.core;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CreateScopeConfiguration {
   
   // disini scope yang baru kita buat diregistrasikan
   @Bean(value = "customScopeConfigurer")
   public CustomScopeConfigurer configurer(){
      CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
      customScopeConfigurer.addScope("doubleton", new DoubletonScope());
      return customScopeConfigurer;
   }
   
   // scope digunakan
   @Scope(value = "doubleton")
   @Bean(value = "foo")
   public Foo foo(){
      log.info("==> FOO HAS CREATED WITH DOUBLETON SCOPE <==");
      return new Foo();
   }
}

```

menguji custom scope
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;


public class CreateScopeConfigurationTest {
   
   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(CreateScopeConfiguration.class);
   }

   @Test
   void testDoubleton(){
      Foo foo1 = this.context.getBean("foo",Foo.class);
      Foo foo2 = this.context.getBean("foo",Foo.class);
      Foo foo3 = this.context.getBean("foo",Foo.class);
      Foo foo4 = this.context.getBean("foo",Foo.class);

      Assertions.assertNotNull(foo1);
      Assertions.assertSame(foo1, foo3);
      Assertions.assertSame(foo2, foo4);
      Assertions.assertNotSame(foo1, foo2);
      Assertions.assertNotSame(foo3, foo4);
   }
}
```

# Lifecycle Spring container Ioc
Container Inversion Of Control memiliki daur hidup atau biasa disebut Lifecycle, dan kita juga bisa berintrasksi dengan Lifecycle dari container ioc.  
Saat pertamakali Applikasi Spring dinyalakan dan Container Ioc selesai membuat bean, Spring framework akan memberitahu bahwa bean telah selesai dibuat, artinya semua proses dependency injection telah selesai dilakukan.  
Dan disaat Applikasi Spring akan dimatikan maka Container ioc akan memberitau semua bean bahwa bean tersebut akan dimatikan(dihancurkan).  

# Lifecycle callback
Bean pada spring framewrok tidak mengetahui Lifecycle dari Spring ketika selesai membuat bean dan ketika akan menghamcurkan atau mematikan semua bean.  
Jika kita ingin berintraksi dengan Lifecycle Spring framework, kita bisa mengimplementasikan [InitializingBean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/InitializingBean.html)(untuk berintraksi ketika Spring selesai membuat semua bean).  
[DisposableBean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/DisposableBean.html)(untuk berintraksi ketika Applikasi Spring akan dimatikan dan semua bean akan di hancurkan).  

``` java
package com.basicconfiguration.spring.core.helper.lifeCycleBean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Connection implements InitializingBean, DisposableBean {

   /**
    * method ini akan secara otomatis di panggil ketika spring telah selesai membuat Bean
    */
   @Override
   public void destroy() throws Exception {
      log.info("connection has closed");
      
   }

   /**
    * method ini akan di panggil secara otomatis ketika appl;ikasi spring di matikan
    */
   @Override
   public void afterPropertiesSet() throws Exception {
      log.info("connection has ready to be use");
      
   }  
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.MainServer;
import com.basicconfiguration.spring.core.helper.Server;
import com.basicconfiguration.spring.core.helper.lifeCycleBean.Connection;

@Configuration
public class LifeCycleConfiguration {
   /**
    * Agar class Connection(kelas implementasi DisposableBean, InitializingBean) diekseskusi
    * maka kita harus menjadikan kelas tersebut menjadi Bean dan dimasukan kedalam Spring Container Ioc
    * */
   @Bean(value = "connection")
   public Connection connection(){
      return new Connection();
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.MainServer;
import com.basicconfiguration.spring.core.helper.Server;
import com.basicconfiguration.spring.core.helper.lifeCycleBean.Connection;

public class LifeCycleConfigurationTest {

   /**
    * agar nanti ketika applikasi spring akan di matikan secara otomatis akan mengclose connection
    * kita harus mengganti Applicationcontex dengan ConfigurableApplicationContex untuk mengkases 
    * method close();
    * karna di class ApplicationContex tidak ada method close();
    */
   // private ApplicationContext context;
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
      this.context.registerShutdownHook();
   }
   @AfterEach
   void teatDown(){
      /**
       * jika kita tidak mau melakukan secara manual untuk meng destroy connection kita bisa melakukan 
       * dengan method registerShutDownHook(); 
       */
      // this.context.close();
   }

   @Test
   void lifeCycleTest(){
      Connection connection = this.context.getBean("connection",Connection.class);
      Assertions.assertNotNull(connection);

      /**
       * kita tidak perlu melakukan connection.afterPropertySet(); untuk mengeksekusi suatu bean
       * ketia spring telah membuat bean klaena secara otomatis spring akan mengeksekusi nya setelah
       * bean selesai di buat.
       * dan kita tidak perlu melakukan connection.destroy(); karna secara otomatis spring akan memberi 
       * tau kepada bean nya jikalau mau di hancurkan jadi secara otomatis nanti akan di close by spring
       */
   }
}
```

# Lifecycle Annotation
Selain menggunakan interface InitializingBean dan DisposableBean, kita bisa juga memanfatkan annotation @Bean untuk mendaftarkan callback method pada Lifecycle spring.  
Pada annotation @Bean terdapat initMethod() untuk mengeksekusi method ketidak bean selesai dibuat, destroyMethod() untuk mengeksekusi method ketika bean akan dimatikan atau dihancurkan.  
untuk membuat method callback Lifecycle, method tidakboleh memiliki parameter dan return value.  

``` java
package com.basicconfiguration.spring.core.helper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {
   
   public void start(){
      log.info("the server has been started");
   }

   public void stop(){
      log.info("the server has been stoped");
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.MainServer;
import com.basicconfiguration.spring.core.helper.Server;
import com.basicconfiguration.spring.core.helper.lifeCycleBean.Connection;

@Configuration
public class LifeCycleConfiguration {
   /**
    * bean ini akan mengeksekusi method start yang ada didalam keals Server
    * ketika Bean selesai dibuat, dan juga akan mengeksekusi method stop
    * ketika bean akan dimatikan atau dihancurkan
    * */
   @Bean(value = "server",initMethod = "start",destroyMethod = "stop")
   public Server server(){
      return new Server();
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.MainServer;
import com.basicconfiguration.spring.core.helper.Server;
import com.basicconfiguration.spring.core.helper.lifeCycleBean.Connection;

public class LifeCycleConfigurationTest {

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void testServer(){
      Server server = this.context.getBean("server", Server.class);
      Assertions.assertNotNull(server);
   }
}
```

# @PostConstruct dan @PreDestroy
Selain dengan cara implementasi InitializingBean dan DesposibleBean atau memanfaatkan annotation @Bean kita juga dapat memanfaatkan Annotations @PostConstruct(Untuk berintraksi kepada Lifecycly saat bean selesai dibuat) dan @PreDestroy(untuk berintraksi kepada Lifecycle ketika bean akan dimatikan atau dihancurkan).  

``` java
package com.basicconfiguration.spring.core.helper;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainServer {
   /**
    * jika Method di annotasi dengan @PostConstruct maka method tersebut harus dipanggil ketika bean selesai dibuat
    * Jika method di anotasi sebagai @Predestroy maka method tersebut harus dipanggil ketika bean akan dihancurkan
    * jika sudah menggunakan annotation ini kita tidak perlu lagi menyebutkan di @bean
    */
   @PostConstruct
   public void startMainServer(){
      log.info("****the main server has started****");
   }

   @PreDestroy
   public void stopMainServer(){
      log.info("****the main server has stoped****");
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.MainServer;
import com.basicconfiguration.spring.core.helper.Server;
import com.basicconfiguration.spring.core.helper.lifeCycleBean.Connection;

@Configuration
public class LifeCycleConfiguration {
   /**
    * Pada annotasi  @Bean ini kita tidakperlu lagi memanggil
    * initMethod dan destroyMethod, karena untuk berintraksi 
    * saat pertamakali selesai dibuat bean telah di handle
    * oleh @PostConstruct dan @PreDestroy untuk berintraksi ketika
    * bean akan dimatikan atau dihancurkan
    * */
    @Bean(value = "mainServer")
    public MainServer mainServer(){
       return new MainServer();
    }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.MainServer;
import com.basicconfiguration.spring.core.helper.Server;
import com.basicconfiguration.spring.core.helper.lifeCycleBean.Connection;

public class LifeCycleConfigurationTest {

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
      this.context.registerShutdownHook();
   }

   /**
    * ini kita tidak perlu meng close jga karna secara default telah di handle oleh 
    * annotation @PreConstruct dan @PreDestroy
    */
   @Test
   void testMainServer(){
      MainServer mainServer = this.context.getBean("mainServer",MainServer.class);
      Assertions.assertNotNull(mainServer);
   }
}
```

# @Import
Saat applikasi semakin besar dan kompleks, biasanya konfigurasinya akan tambah banyak dan kompleks.  
Spring memiliki annotation @Import untuk menggabungkan beberapa konfigurasi kedalam 1 Class.  
Ketika kita menggunakan annotasi @Import kita bisa meng inport banuak kelas.  

``` java
package com.basicconfiguration.spring.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class FooConfiguration {

   @Bean
   public Foo foo(){
      return new Foo();
   }
}
```

``` java
package com.basicconfiguration.spring.core.examplecomponentscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Bar;

@Configuration
public class BarConfiguration {
   
   @Bean(value = "bar")
   public Bar bar(){
      return new Bar();
   }
}
```

``` java
package com.basicconfiguration.spring.core.importConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
@Import({
   Foo.class,
   Bar.class
})
public class MainConfiguration { }
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.importConfig.MainConfiguration;

public class ImportConfigurationTest {
   
   private ConfigurableApplicationContext context;
   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(MainConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void testMainConf(){
      Foo foo = this.context.getBean(Foo.class);
      Bar bar = this.context.getBean(Bar.class);

      Assertions.assertNotSame(foo, bar);
   }
}
```

# @ComponentScan
Ada kalanya kita akan mengimport banyak sekali konfigurasi, melakukan import satu persatu sudah tidak lagi direkomendasikan.  
Spring framework memiliki annotation @ComponentScan yang bisa kita gunakan untuk melakukan import.  
[@ComponentScan](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/ComponentScan.html) ini secara otomatis akan meng import configuration diseluruh package dan sub package nya, dengan begitu kita tidak perlu melakukan import satu persatu.  


``` java
package com.basicconfiguration.spring.core.examplecomponentscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Bar;

@Configuration
public class BarConfiguration {
   
   @Bean(value = "bar")
   public Bar bar(){
      return new Bar();
   }
}
```

``` java
package com.basicconfiguration.spring.core.examplecomponentscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class FooConfiguration {

   @Bean(value = "foo")
   public Foo foo(){
      return new Foo();
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * Spring akan melakukan Scaning kepada package ini dan jikalau
 * Spring mememukan class yang di annotasi sebagai @Configuration
 * maka class tersebut akan di Import dan jikalau Spring menemukan
 * sub package maka semua class didalam sun package tersebut akan 
 * ikut di import
 */
@ComponentScan(basePackages = {
    "com.basicconfiguration.spring.core.examplecomponentscan"
})
public class ComponentScanConfiguration { }
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;

public class ComponentScanConfigurationTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        this.applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
        this.applicationContext.registerShutdownHook();
    }

    @Test
    public void testComponentScan() {
        Foo foo = this.applicationContext.getBean("foo", Foo.class);
        Bar bar = this.applicationContext.getBean("bar", Bar.class);
        Assertions.assertNotNull(bar);
        Assertions.assertNotNull(foo);
    }
}
```

# @Component
kita telah membahas cara membuat bean, yaitu denegan cara membuat class yang diberi annotasi @Configuration dan didalam class tersebut kita dapat membuat method yang dianotasi dengan @Bean  
Spring framework juga memiliki cara otomatis untuk membuat bean tampa menggunakan annotasi @Bean, yaitu dengan mengganti annotasi @Configuration pada class menjadi @Component, dengan begitu kelas tersebut akan dijadikan sebuah bean.  
|  annotations    |  perbedaan                                                                                                                                |
|-----------------|-------------------------------------------------------------------------------------------------------------------------------------------|
|  @Component     |  class berisi single bean, jikalau ada lebih dari 1 bean maka harus menggunakan annotasi @Bean, dan class akan dianggap sebagai Bean baru |
|  @Configuration |  class boleh memiliki banyak method bean, dan class diangap sebagai file konfigurasi baru                                                 |

Jika ada method didalam clas tersebut maka akan secara ototmatis dijadikan Bean.  
@Component hanya mendukung satu pembuatan Bean, jika kita ingin membuat beberapa Bean dalam 1 Application context maka kita tetap menggunakan annotation @Bean.  

# Componen Bean Name 
Saat kita menggunakan @Component, nama bean akan secara otomatis dibuatkan oleh Spirng.  
Saat kita ingin menggunakan @ComponentScan, secara otomatis bean akan menggunakan nama class nya, namun menjadi camelCase misalnya UserService menjadi userService.  
jika kita menggunakan @Import secara otomatis nama bean menjadi NamaClass.clss.getName(), misalnya UserService menjadi UserService.class.getname()  
Jika kita ingin membuat nama bean nya sesuai keinginan kita bisa menggunakan @Component(value = "nama_bean")  
  
class yang di annotasi sebagai @Component ini dapat kita memperlakukan layaknya seperti annotasi @Bean, jadi kita bisa menambahkan @Lazy, @Scope @Primary @PreDestroy Dan sebagainya.  

``` java
package com.basicconfiguration.spring.core.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component(value = "productService")
public class ProductService { }
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {
   "com.basicconfiguration.spring.core.service"
})
@Configuration
public class ComponentConfiguration { }
``` 

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.service.ProductService;

public class ComponentconfigurationTest {
   
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
   }

   @Test
   void testComponent(){
      ProductService productService1 = this.context.getBean("productService", ProductService.class);
      ProductService productService2 = this.context.getBean("productService", ProductService.class);

      Assertions.assertNotNull(productService1);
      Assertions.assertNotNull(productService2);
      Assertions.assertSame(productService1, productService2);
   }
}
```

# Constructor Dependency Injection
Saat kita membuat bean yang ketergantungan dengan bean lain(Dependency Injection), kita dapat menambahkan parameter pada method bean terserbut.  
namun bagaimana jikalau kita menggunakan @Component tentusaja kita tidak bisa melakukan hal tersebut dong ??.  
Saat kita menggunakan @Componenet, dan kita ingin melakukan injection pada component tersebut maka kita dapat menggunakan  
Constructor denga parameter.  
``` java
package com.basicconfiguration.spring.core.repository;

import org.springframework.stereotype.Component;

@Component
public class ProductRepository { }
```

``` java
package com.basicconfiguration.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.repository.ProductRepository;

@Lazy
@Component(value = "productService")
public class ProductService {
  
   private ProductRepository productRepository;

   /**
    * dengan memanfaatkan constructor maka kita dapat melakukan 
    * Injection pada kelas yang dianotasi sebgai component
    * */
   public ProductService(ProductRepository productRepository){
      this.productRepository = productRepository;
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {
   "com.basicconfiguration.spring.core.repository",
   "com.basicconfiguration.spring.core.service"
})
@Configuration
public class ComponentConfiguration { }
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.repository.ProductRepository;
import com.basicconfiguration.spring.core.service.ProductService;

public class ComponentconfigurationTest {
   
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
   }

   @Test
   void productRepoTest(){
      ProductService productService = this.context.getBean(ProductService.class);
      ProductRepository productRepository = this.context.getBean(ProductRepository.class);
      Assertions.assertSame(productRepository,productService.getProductRepository());
   }
}
```

# Multiple Constructor
Pada penjelasan sebelumnya kita telah mengetahui bahwa Spring hanya mendukung 1 Dependency Injection constructor based.  
Namun bagaimana jikalau kita memiliki multiple Constructor ??.  
yang harus dilakukan adalah kita harus menentukan constructor default nya dengan cara memberi annotasi @Autowired kepada constructor yang dikehendaki

``` java
package com.basicconfiguration.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.repository.ProductRepository;

@Lazy
@Component(value = "productService")
public class ProductService {
  
   private ProductRepository productRepository;

   /**
    * Perlu diingat saat terdapat lebih dari 1 constructor 
    * maka kita harus menentukan defaut injection nya dengan menambahkan
    * annotasi @Autowired
    */
   @Autowired
   public ProductService(ProductRepository productRepository){
      this.productRepository = productRepository;
   }

   public ProductService(ProductRepository productRepository, String name){
      this.productRepository = productRepository;
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.repository.ProductRepository;
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
      Assertions.assertSame(productService1, productService2);
   }
}
```

# Setter Dependency Injection
Setter Dependency Injection merupakan teknik Injection melalui method Setter.  
Khusus untuk Dependency Injection setter based kita harus menambahkan annotasi @Autowired pada setter method
dengan begitu Spring container ioc akan mencarikan bean berdasarkan parameter injection pada setter method.  
Setter Injection dapat di gabungkan juga dengan COnstructor Injection.  

``` java
package com.basicconfiguration.spring.core.repository;

import org.springframework.stereotype.Component;

@Component
public class CategoryRepository { }
```

``` java
package com.basicconfiguration.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.repository.CategoryRepository;

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
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.repository.CategoryRepository;
import com.basicconfiguration.spring.core.service.CategoryService;

public class ComponentconfigurationTest {
   
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
   }

   @Test
   void testDependencyInjectionBySetter(){
      CategoryRepository category  = this.context.getBean(CategoryRepository.class);
      CategoryService service = this.context.getBean(CategoryService.class);

      Assertions.assertSame(category, service.getRepository());
   }
}
```

# Optional Dependency
Saat kita melakukan Dependency Injection entah itu menggunakan method atau constructor atau Seter, secara default Dependency tersebut bersifat Mandatory atau Wajib ada.  
Namu pada kasus tertentu kandang kita ingin dependency nya itu bersifat Optional artinya jikalau dependency tersebut tidak ada maka tidak apa-apa(tidak terjadi Error).  
Untuk melakukan hal tersebut kita dapat memanfaatkan Optional\<T> pada metod parameter injection, atau constructor injection, atau pada seter parameter Injection.  
Dengan begitu ketika dependency nya tidak ditemukan maka tidak akan terjadi error.  

``` java
package com.basicconfiguration.spring.core;

import java.util.Optional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

@Configuration
public class OptionalConfiguration {

   @Bean(value = "foo")
   public Foo foo(){
      return new Foo();
   }

   @Bean(value = "fooBar")
   /**
    * dengan membungkus parameter nya dengan Optional
    * maka jikalau bean nya tidak ditemukan maka tidak akan terjadi error
    * karena Dependency nya bersifat Optional
    */
   public FooBar fooBar(Optional<Foo> foo, Optional<Bar> bar){
      return new FooBar(foo.orElse(null),bar.orElse(null));
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

public class OptionalDependencyTest {
   
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void OptionalTest(){
      Foo foo = this.context.getBean("foo",Foo.class);
      FooBar fooBar = this.context.getBean("fooBar",FooBar.class);

      /**
       * fooBar.getBar() akan mengembalikan niali null
       * karena kita tidak membuatkan bean dengan tidap Bar
       * */
      Assertions.assertNull(fooBar.getBar());
      Assertions.assertSame(foo, fooBar.getFoo());
   }
}
```

# Factory Bean
Terkadang kita ingin membauat bean dari class atau object yang tidak bisa kita ubah lagi atau tidak bisa kita kontrol, misalnya Third party Liberary dan sebagainya.  
pada kausu seperti ini kita membuat bean  nya menggunakan @Bean method.  
Atau menggunakan annotasi @Componen atau @Configuration dnegan mengimplemmentasikan interface [FactoryBean\<T>](https://docs.spring.io/spring-framework/docs/current/javadocs-api/org/springframework/beans/factory/FactoryBean.html), FactoryBean\<T> ini cocok banget jikalau kita ingin membuat bean dari third party liberary.  

``` java
package com.basicconfiguration.spring.core.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * kita analogikan kelas ini sebagai third party liberary
 * dan kita tidak memiliki kendali untuk menambahkan annotasi
 * @Component pada class ini
 */
@NoArgsConstructor
@Setter @Getter @AllArgsConstructor
public class PaymetGateway {
    
    private String endpoint;

    private String publicKey;

    private String secretKey;
}
```

``` java
package com.basicconfiguration.spring.core.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.client.PaymetGateway;

@Component(value = "PaymentGateway")
public class PaymentGatewayFactoryBean implements FactoryBean<PaymetGateway> {

    /**
     * method ini nantinya kan membuatkan Object Bean PaymentGateway
     * jika disini kita ingin melakukan depoendency Injection, kita dapat melakukanya dengan
     * bisa menggunakan construcotr injection, atau Seter Injectionm ataupun method parameter Injection
     */
    @Override
    public PaymetGateway getObject() throws Exception {
        PaymetGateway paymetGateway = new PaymetGateway();
        paymetGateway.setEndpoint("https://examplePaymentGateway.com/req");
        paymetGateway.setPublicKey("public_key");
        paymetGateway.setPrivateKey("private_key");
        return paymetGateway;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymetGateway.class;
    } 
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.factory.PaymentGatewayFactoryBean;
import com.basicconfiguration.spring.core.factory.PaymentGetwayClientFactoryBean;

@Configuration
@Import({
   PaymentGatewayFactoryBean.class
})
public class FactoryConfiguration { }

```

``` java
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
   public void testFactoryBean() {
      PaymetGateway paymentGateway = this.context.getBean(PaymetGateway.class);
      Assertions.assertNotNull(paymentGateway);
      Assertions.assertSame("https://examplePaymentGateway.com/req", paymentGateway.getEndpoint());
      Assertions.assertSame("private_key", paymentGateway.getPrivateKey());
      Assertions.assertSame("public_key", paymentGateway.getPublicKey());
   }
}
```

# Inheritance
Kita dapat mengakses bean menggunakan Tipe bean nya langsung atau dari parent class/interface nya.  
Misalnya kita memiliki interface UserService dan kita memiliki object implementasinya yang bernama UserSercviceImpl.  
maka untuk mengakses bean nya kita bisa dari UserServiceImpl dan UserService.  
Namun perlu berhati-hati, jika UserService memiliki banyak implementasi bean bisa terjadi error duplicate, maka dari itu perlu diperhatikan dengan teliti.  

``` java
package com.basicconfiguration.spring.core.example.service;

public interface UserService { }
```

``` java
package com.basicconfiguration.spring.core.example.serviceImpl;

import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.example.service.UserService;

@Component
public class UserServiceImpl implements UserService { }
```

``` java
package com.basicconfiguration.spring.core.example;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.example.serviceImpl.UserServiceImpl;

@Component
@Import(value = {
    UserServiceImpl.class
})
public class InheritanceConfiguration { }
```

``` java
package com.basicconfiguration.spring.core.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.example.service.UserService;
import com.basicconfiguration.spring.core.example.serviceImpl.UserServiceImpl;

public class InheritanceTest {
    
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testInheritance() {
        UserServiceImpl userServiceImpl = this.context.getBean(UserServiceImpl.class);
        UserService userService = this.context.getBean(UserService.class);
        Assertions.assertNotNull(userService);
        Assertions.assertNotNull(userServiceImpl);
        Assertions.assertSame(userServiceImpl, userService);
    }
}
```

# FactoryBean
ApplicationContext merupakan turunan dari BeanFactory.  
BeanFactory ini merupakan kontrak untuk menejemen Bean di spring framework.  
Method-method yang sering kita gunakan misalnya method getBean() dan sebagainya, itu merupakan method kontrak milik interface [FactoryBean](https://docs.spring.io/spring-framework/docs/current/javadocs-api/springframework/beans/factory/BeanFactory.html)

# ListableBeanFactory
FactoryBean hanya bisa digunakan untuk megambil atau mengakses single Bean, mislanya kita ingin mengambil beberapa bean maka kita harus menyebutkan nama bean tersebut satu persatu.  
Terkadang dalam case tertentu kita ingin mengambil semua bean sekaligus, untuk kasus seperti itu kita dapat memanfaatkan [ListableBeanFactory](https://docs.spring.io/spring-framework/docs/current/javadocs-api/springframework/beans/factory/ListableBeanFactory.html)  
ListableBeanFactory merupakan turunan dari interface FactoryBean, dan ApplicationContext merupakan turunan dari ListableBeanFactory.  

``` java 
package com.basicconfiguration.spring.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class FooConfiguration {

   @Bean
   public Foo foo1(){
      return new Foo();
   }
   @Bean
   public Foo foo2(){
      return new Foo();
   }
   @Bean
   public Foo foo3(){
      return new Foo();
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {
   "com.basicconfiguration.spring.core.configuration"
})
@Configuration
public class ComponentConfiguration { }
```

``` java 
package com.basicconfiguration.spring.core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;

public class BeanFactoryTest {
   
   // ConfigurableApplicationContext juga merupakan interface turunan dari ListableBeanFactory
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void testBean(){

      //ini mereturn bean tapi kita tidak dengan nama bean nya
      ObjectProvider<Foo> foo = this.context.getBeanProvider(Foo.class);
      List<Foo> collection = foo.stream().collect(Collectors.toList());
      System.out.println(collection);
      Assertions.assertEquals(3, collection.size());

      //ini mereturn bean  dan nama bean nya
      Map<String,Foo> beans = this.context.getBeansOfType(Foo.class);
      Assertions.assertEquals(3, beans.size());
   }
}
```

# BeanPostProcessor
Merupakan interface yang digunakan untuk memodifikasi proses pembuatan Bean di ApplicationContext  
[BeanPostProcessor](https://docs.spring.io/spring-framework/docs/current/javadocs-api/org/springframework/beans/factory/config/BeanPostProcessor.html) ini mirip seperti Interceptor atau Middleware, BeanPostProcessor ini memiliki 2 method yaitu : 
   * postProcessAfterInitialization(object, name) di eksekusi saat proses pembuatan bean selesai
   * postProcessBeforeInitialization(object, name) di eksekusi saat proses pembuatan bean belum selesai dubuat
  
Misalnya kita memiliki kasus yang mana jikalau ada sebuah bean yang implementasi interface IdAware, maka kita akan buatkan unique id kepada bean tersebut.  

``` java
package com.basicconfiguration.spring.core.aware;

public interface IdAware {
   
   public void setId(String id);

   public String getId();
}
```

``` java
package com.basicconfiguration.spring.core.processor;

import java.util.UUID;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.aware.IdAware;
import lombok.extern.slf4j.Slf4j;

/**
 * Saat proses pembuatan bean, kelas ini akan selalu di eksekusi, 
 * seperti yang kita jelaskan sebelumnya, BeanPostProcesscor itu mirip seperti Middleware
 * atau simpelnya Filter
 * */
@Component @Slf4j
public class IdGeneratorPostProcessor implements BeanPostProcessor {

   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      log.info("Id generator processor for Bean {} ", beanName);
      /**
       * jikalau ada Bean yang mengimplementasi IdAware maka akan diberikan unique Id
       * **/
      if (bean instanceof IdAware){
         log.info("set Id generator for Bean {} ", beanName);
         IdAware idAware = (IdAware) bean;
         idAware.setId(UUID.randomUUID().toString());
      }
      return bean;
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.helper.Person;
import com.basicconfiguration.spring.core.processor.IdGeneratorPostProcessor;

@Configuration @Import(value = {
    Person.class,
    IdGeneratorPostProcessor.class
})
public class PersonBeanPostProcessorConfiguration { }
```

``` java
package com.basicconfiguration.spring.core.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.PersonBeanPostProcessorConfiguration;
import com.basicconfiguration.spring.core.helper.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonBeanPostProcessorTest {
    
    private ConfigurableApplicationContext context;
    
    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(PersonBeanPostProcessorConfiguration.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testPerson() {
        Person person = this.context.getBean(Person.class);  
        log.info("UNIQUE ID BEAN PERSON {}", person.getId());
    }
}
```

# Ordered interface
Terkadang kita akan mendapatkan kasus yang mana harus membuat beberapa implementasi BeanPostProcessor dan Implementasi tersebut di eksekusi secara berurutan.  
Sayangnya Spring container Ioc secara default tidak mengurutkan eksekusi beberapa implementasi BeanPostProcessor.  
Untuk menangani kasus tersebut kita dapat meng implementasi interface [Ordered](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/Ordered.html)  


``` java 
package com.basicconfiguration.spring.core.aware;

public interface IdAware {
   
   public void setId(String id);

   public String getId();
}
```

``` java
/**
 * BeanPostProcessor ini akan dieksekusi pertama kali
 * karena method getOrder mengembalikan nilai paling kecil
 * */
@Component @Slf4j
public class IdGeneratorPostProcessor implements BeanPostProcessor, Ordered {
   
   @Override
   public int getOrder() {
      return 1;
   }

   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      log.info("Id generator processor for Bean {} ", beanName);
      if (bean instanceof IdAware){
         log.info("set Id generator for Bean {} ", beanName);
         IdAware idAware = (IdAware) bean;
         idAware.setId(UUID.randomUUID().toString());
      }
      return bean;
   }
}
```

``` java
package com.basicconfiguration.spring.core.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.aware.IdAware;
import lombok.extern.slf4j.Slf4j;

/**
 * BeanPostProcessor ini akan dieksekusi ke 2
 * */
@Component @Slf4j
public class PrefixIdGeberatorPostProcessor implements BeanPostProcessor, Ordered {

   @Override
   public int getOrder() {
      return 2;
   }
   
   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      log.info("Prefix Id Generator Processor for Bean {} ", beanName);
      if (bean instanceof IdAware){
         log.info("Prefix set Id Generator Processor for Bean {} ", beanName);
         IdAware idAware =  (IdAware) bean;
         idAware.setId("Second-" + idAware.getId());
      }
      return bean;
   }
}
```

``` java
package com.basicconfiguration.spring.core.helper;

import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.aware.IdAware;

@Component(value = "Person")
public class Person implements IdAware {
    
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
       return this.id;
    }
}
```

``` java
package com.basicconfiguration.spring.core.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.PersonBeanPostProcessorConfiguration;
import com.basicconfiguration.spring.core.helper.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBeanPostProcessorOrdered {
    
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(PersonBeanPostProcessorConfiguration.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testOredred() {
        Person person = this.context.getBean(Person.class);
        Assertions.assertNotNull(person.getId());
        Assertions.assertTrue(person.getId().startsWith("Second-"));
        log.info(person.getId());
    }   
}
```

# Aware
Aware merupakan interface milik Spring yang digunakan unutuk semua [Aware](https:docs.spring.io/spring-framework/docs/current/javadocs-api/org/springframework/beans/factory/Aware.html) interface.  
Aware ini diperuntukan sebagai Penanda agar spring melakukan Injection object yang kita butuhkan  
Aware ini mirip seperti yang sudah kita lakukan ketika membuat IdAware menggunakan IdGenerator BeanPostProcessor, Namun kita tidak perlu lagi membuat BeanPostProcessor secara manual.  

|  Aware                         |  Ket                                      |
|--------------------------------|-------------------------------------------|
|  BeanFactoryAware              |  Untuk mendapatkan BeanFactory            |
|  ApplicationContextAware       |  Untuk mendapatkan ApplicationContext     |
|  BeanNameAware                 |  Untuk mendapatkan nama Bean              |
|  ApplicationEvenPublisherAware |  Untuk mendapatkan EvenPublisher          |
|  EnvironmentAware              |  Untuk mendapatkan Environment            |
|  dll .....                     | ...                                       |
  
  
``` java
package com.basicconfiguration.spring.core.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AuthService implements ApplicationContextAware, BeanNameAware, EnvironmentAware {

   /**
    * Property-propery ini secara otomatis akan di inject oleh Spring container Ioc
    * melalui method-method overide nya
    * */
   private String beanName;

   private ApplicationContext applicationContext;

   private Environment environment;
   
   @Override
   public void setBeanName(String name) {
      this.beanName = name;
   }

   public String getBeanName() {
      return beanName;
   }

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      this.applicationContext = applicationContext;
   }
   public ApplicationContext getApplicationContext() {
      return applicationContext;
   }

   @Override
   public void setEnvironment(Environment environment) {
      this.environment = environment;
   }

   public Environment getEnvironment() {
      return this.environment;
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.service.AuthService;

@Import(value = {
    AuthService.class
})
public class AwareConfiguration { }
```

``` java
package com.basicconfiguration.spring.core.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.AwareConfiguration;
import com.basicconfiguration.spring.core.service.AuthService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AwareTest {
    
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(AwareConfiguration.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testAuthService() {
        AuthService authService = this.context.getBean(AuthService.class);
        Assertions.assertEquals(AuthService.class.getName(), authService.getBeanName());
        log.info(authService.getBeanName());
        Assertions.assertNotNull(authService.getEnvironment());
        Assertions.assertSame(this.context, authService.getApplicationContext());        
    }
}
```
# Application Event Publisher
ApplicationEventPublisher merupakan suatu object untuk mengirimkan suatu event kepada Listener, ApplicationEventPublisher juga merupakan super interface dari ApplicationContext.  
Untuk mendapatkan object ApplicationEventPublisher kita dapat mengimplementasikan interface [ApplicationEventPublisherAware](https:docs.spring.io/spring-framework/docs/current/javadocs-api/org/springframework/context/ApplicationEventPublisher.html)  

# Application Event Listener
Spring memiliki fitur Event Listener untuk mendengarkan suatu kejadian atau event yang dikirimkan oleh Event Publisher  
Event pada Spring merupakan object turunan dari [ApplicationEvent](https:docs.spring.io/spring-framework/docs/current/javadocs-api/org/springframework/context/ApplicationEvent.html) sedangkan Listener merupakan turunan dari [ApplicationListener](https:docs.spring.io/spring-framework/docs/current/javadocs-api/org/springframework/context/ApplicationListener.html)  

``` java
package com.basicconfiguration.spring.core.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class User {
   
   private String userName;
   
}
```

``` java
package com.basicconfiguration.spring.core.event;

import org.springframework.context.ApplicationEvent;
import com.basicconfiguration.spring.core.helper.User;
import lombok.Getter;
import lombok.Setter;

/**
 * kelas ini merupakan kelas yang akan di publish ketika ada user yang
 * berhasil login
 * */
@Setter @Getter
public class LogginSuccessEvent extends ApplicationEvent {
   
   private User user;

   public LogginSuccessEvent(User user) {
      super(user);
      this.user = user;
   }
}
```

``` java
package com.basicconfiguration.spring.core.listerner;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.event.LogginSuccessEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * Kelas ini akan mendengarkan kejadian atau event yang 
 * tipe nya LogginSuccessEvent
 * */
@Component
@Slf4j
public class LogginSuccessListener implements ApplicationListener<LogginSuccessEvent> {

   @Override
   public void onApplicationEvent(LogginSuccessEvent event) {
      log.info("success loggin for user {} ", event.getUser().getUserName());
   }
}
```

``` java
package com.basicconfiguration.spring.core.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.event.LogginSuccessEvent;
import com.basicconfiguration.spring.core.helper.User;

/**
 * disini kita mengimplementasi ApplicationEventPublisherAware
 * untuk mendapatkan object ApplicationPublisher(secara otomatis di inject oleh Spring Ioc)
 * dan kita akan gunakan untuk mempublish event
 * */
@Component
public class UserService implements ApplicationEventPublisherAware {
   
   private ApplicationEventPublisher applicationEventPublisher;

   // Spring Ioc akan menginject dari method ini
   @Override
   public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
     this.applicationEventPublisher = applicationEventPublisher;
   }

   public boolean login(String userName, String password){
      if(isLoginSucces(userName, password)){
         this.applicationEventPublisher.publishEvent(new LogginSuccessEvent(new User(userName)));// => mengirim Event nya
         return true;
      }else{
         return false;
      }
   }

   public boolean isLoginSucces(String userName, String password){
      return "alliano".equals(userName) && "hagoromo".equals(password);
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.listerner.LogginFaildListener;
import com.basicconfiguration.spring.core.listerner.LogginSuccessListener;
import com.basicconfiguration.spring.core.service.UserService;

public class EventListenerTest {
   
   @Configuration
   @Import(value = {
      UserService.class, 
      LogginSuccessListener.class,
      LogginFaildListener.class
    })
   public static class EventListenerConfiguration{}

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(EventListenerConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void eventListenerTest(){
      UserService userService = this.context.getBean(UserService.class);
      userService.login("alliano", "hagoromo");
      userService.login("jincuriki", "hasirama");
      userService.login("otsusuki hamura", "konoha");
   }
}
```

# @EvenListener
Sealain kita mengimplementasikan interface ApplicationListener, kita juga dapat memanfaatkan annotation [@EventListener](https://docs.spring.io/spring-framework/docs/current/javadocs-api/org/springframework/context/event/EventListener.html) untuk membuat Listener.  
menggunakan annotation @EvenListener sangatlah mudah dan fleksibel.  

``` java
package com.basicconfiguration.spring.core.listerner;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import com.basicconfiguration.spring.core.event.LogginSuccessEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class UserListener {

   /**
    * menggunakan annotation
    * @EventListener
    * */
   @EventListener(classes = LogginSuccessEvent.class)
   public void onLoginSuccesListener(LogginSuccessEvent event){
      log.info("Success login for user {}", event.getUser());
   }
}
```

``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.listerner.LogginFaildListener;
import com.basicconfiguration.spring.core.listerner.LogginSuccessListener;
import com.basicconfiguration.spring.core.listerner.UserListener;
import com.basicconfiguration.spring.core.service.UserService;

public class EventListenerTest {
   
   @Configuration
   @Import(value = {
      UserService.class, 
      LogginSuccessListener.class,
      UserListener.class, 
      LogginFaildListener.class
    })
   public static class EventListenerConfiguration{}

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(EventListenerConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void eventListenerTest(){
      UserService userService = this.context.getBean(UserService.class);
      userService.login("alliano", "hagoromo");
      userService.login("jincuriki", "hasirama");
      userService.login("otsusuki hamura", "konoha");
   }
}
```

# @SpringBootApplication
Sebelumnya kita telah mempelajari cara membuat ApplicationContext secara manual, dan belum menggunakan fitur otomatis dari SpringBoot.  
Saat kita ingin Belajar SpringBoot, lebih baiknya jikalau kita mempelajari SpringFramework atau Spring Core terlebih dahulu agar mengetahui low level bangaimana cara kerja SpringBoot, karena SpringBoot berjalan diatas layer SpringFramework.  
Pada saat kita menggunakan SpringBoot, kita akan mengganti @Configuration, @ComponentScan dan sebagainya pada configuraton utama dengan annotation [@SpringBootApplication](https://docs.spring.io/spring-boot/docs/current/api/org/spirngframework/boot/autoconfigure/SpringBootApplication.html) maka secara otomatis applikasi SpringBoot kita akan di konfigurasi secara otomatis  

``` java
package com.basicconfiguration.spring.core.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.basicconfiguration.spring.core.helper.Foo;

@SpringBootApplication
public class FooApplication {

   @Bean(name = "fooApp")
   public Foo foo() {
      return new Foo();
   }

   public static void main(String... args) {
      // membuat ApplicationContext secara otomatis menggunakan SpringApplication.run
      ConfigurableApplicationContext context = SpringApplication.run(FooApplication.class, args);
      Foo foo = context.getBean(Foo.class);
      System.out.println(foo);
   }
}
```
Saat kita menggunakan annotation @SpringBootApplication,  jikalau ada sub package dari package milik main class
misalnya class main configuration(kelas yang di annotasi dengan @SpringBootApplication) kita berada pada package com.basicconfiguration.spring.core.application  
jikalau ada subpackage nya maka secara otomatis akan di Import oleh springBoot, jadi kita tidak perlu melakukan import secara manual menggunakan @Import ataupun @ComponentScan  
  
Misalnya kita memiliki Bean pada yaang terpisah dengan main configuration 
``` java
package com.basicconfiguration.spring.core.application.ex;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Component(value = "person")
public class Person {
    
    private String name = "Alliano";

}
```

``` java
package com.basicconfiguration.spring.core.application.ex;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Component(value = "foo-X-Person")
public class FooXPerson implements EnvironmentAware {
    
    private Person person;

    private Foo foo;

    private Environment environment;

    public FooXPerson(Foo foo, Person person) {
        this.person = person;
        this.foo = foo;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
```
Maka secara otomatis jikalau kita membutuhkan bean tersebut, kita tidak perlu melakukan import manual  

``` java
package com.basicconfiguration.spring.core.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.basicconfiguration.spring.core.application.ex.FooXPerson;
import com.basicconfiguration.spring.core.helper.Foo;

@SpringBootApplication
public class FooApplication {

   @Bean(name = "fooApp")
   public Foo foo() {
      return new Foo();
   }

   public static void main(String... args) {
      ConfigurableApplicationContext context = SpringApplication.run(FooApplication.class, args);
      // disini kita mengakses bean FooXPerson yang telah di import secara otomatis oeleh springBoot
      FooXPerson fooxPerson = context.getBean(FooXPerson.class);
      System.out.println(fooxPerson.getEnvironment());
   }
}
```

# @SpringBootTest
Untuk membuat unit test pada SpringBoot application kita bisa memanfatkan annotation [@SpringBootTest(classes = "MainCllass.class")](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/context/SpringBootTest.html)  
Jika sebelumnya saat kita akan melakukan unit test pada application spring kita selalu menggunakan ApplicationContext untuk mendapatkan bean nya, jikalau kita menggunakan @SpringBootTest maka kita tidak perlu menggunakan ApplicationContext, kita kucup meng inject bean yang ingin kita mau test menggunakan @AutoWired annotation  
``` java
package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.basicconfiguration.spring.core.application.FooApplication;
import com.basicconfiguration.spring.core.application.ex.FooXPerson;

@SpringBootTest(classes = FooApplication.class)
public class FooApplicationTest {

	@Autowired
	FooXPerson fooXPerson;

	@Test
	public void testFooxPerson() {
		Assertions.assertNotNull(fooXPerson);
		System.out.println(fooXPerson.getPerson().getName());
	}
}
```

# SpringApplicationEvent
Sebelumnya kita telah mempelajari cara membuat EvenListener di SpirngFramework  
SpringBoot memiliki banyak sekali Event yang di kirim saat applikasi SpringBoot berjalan  
jikalau kita ingin membuat listener untuk menerima event tersebut(kususnya event yang ketriger sebelum ApplicationContext dibuat)  
https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/context/event/SpringApplicationEvent.html  
  
Ada banyak sekali event buatan SpringBoot yang dapat kita listen
|  event                                |  deskripsi                                                           |
|---------------------------------------|----------------------------------------------------------------------|
|  ApplicationEvent                     | Event dikirimkan ketika applikasi di Start                           |
|  ApplicationContextInitializedEvent   | Event Dikirimkan ketika ApplicationContext selesai di initialisasi   |
|  ApplicationStartedEvent              | Event dikirim ketika Applikasi sudah berjalan                        |
|  ApplicationFailedEvent               | Event dikirim ketika Applikasi gagal di jalankan                     |
|  dsb....                              | ......                                                               |
  
Misalnya kita ingin mendengarkan event ketika Applikasi di start, tentunya event tersebut akan di triger sebelum applikasi berjalan dengan normal, dan oleh karna intu masalah yang kita dapatkan adalah kita tidak bisa meregistrasikan nya sebagai Bean.  
untuk mengatasi hal tersebut kita dapat meregistrasikan event listener nya dengan menggunakan class SpringApplication.  

``` java
package com.basicconfiguration.spring.core.application.events;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnStartingApplicationListener implements ApplicationListener<ApplicationStartingEvent> {
    
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("APPLICATION STARTING.......");
    }
}
```

``` java
package com.basicconfiguration.spring.core.application;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.basicconfiguration.spring.core.application.listeners.OnFailureStartListener;
import com.basicconfiguration.spring.core.application.listeners.OnStartingApplicationListener;
import com.basicconfiguration.spring.core.helper.Foo;

@SpringBootApplication
public class FooApplication {

   @Bean(name = "fooApp")
   public Foo foo() {
      return new Foo();
   }

   public static void main(String... args) {
      /**
       * disini kita menggunakan class SpringApplication untuk meregistrasikan 
       * Listener
       * */
      SpringApplication springApplication = new SpringApplication(FooApplication.class);
      // meregistrasikan Listener
      springApplication.setListeners(List.of(new OnStartingApplicationListener()));
      springApplication.run(args);
   }
}
```

