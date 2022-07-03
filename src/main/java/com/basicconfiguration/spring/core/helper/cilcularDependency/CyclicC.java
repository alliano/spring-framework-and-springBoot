package com.basicconfiguration.spring.core.helper.cilcularDependency;

public class CyclicC {
   private CyclicA cyclicA;

   public CyclicC(CyclicA cyclicA) {
      this.cyclicA = cyclicA;
   }

   public CyclicC(){}

   public CyclicA getCyclicA() {
      return cyclicA;
   }

   public void setCyclicA(CyclicA cyclicA) {
      this.cyclicA = cyclicA;
   }

   
}
