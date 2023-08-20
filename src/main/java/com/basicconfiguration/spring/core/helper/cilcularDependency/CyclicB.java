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
