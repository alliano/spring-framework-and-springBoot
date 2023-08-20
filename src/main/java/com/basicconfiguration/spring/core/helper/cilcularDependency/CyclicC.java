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
