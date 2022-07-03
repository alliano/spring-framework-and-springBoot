package com.basicconfiguration.spring.core.helper.cilcularDependency;

public class CyclicA{

   private CyclicB cyclicB;

   public CyclicA(CyclicB cyclicB) {
      this.cyclicB = cyclicB;
   }
   public CyclicA(){}

   public CyclicB getCyclicB() {
      return cyclicB;
   }

   public void setCyclicB(CyclicB cyclicB) {
      this.cyclicB = cyclicB;
   }

}