package com.basicconfiguration.spring.core.helper.cilcularDependency;

public class CyclicB {
   private CyclicC cyclicC;

   public CyclicB(CyclicC cyclicC) {
      this.cyclicC = cyclicC;
   }

   public CyclicC getCyclicC() {
      return cyclicC;
   }

   public void setCyclicC(CyclicC cyclicC) {
      this.cyclicC = cyclicC;
   }

}
