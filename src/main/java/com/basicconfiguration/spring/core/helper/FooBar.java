package com.basicconfiguration.spring.core.helper;


/*
 * @Data annotasi dari dependency lombok => untuk membuat seter geter pada property
 * @AllArgsConstructor annotasi dari dependency lombok => untuk membuat konstruktor
 */
public class FooBar {

   private Foo foo;
   private Bar bar;

   public FooBar(Foo foo, Bar bar) {
      this.foo = foo;
      this.bar = bar;
   }
   public FooBar(){}
   
   public Foo getFoo() {
      return foo;
   }
   public void setFoo(Foo foo) {
      this.foo = foo;
   }
   public Bar getBar() {
      return bar;
   }
   public void setBar(Bar bar) {
      this.bar = bar;
   }




}
