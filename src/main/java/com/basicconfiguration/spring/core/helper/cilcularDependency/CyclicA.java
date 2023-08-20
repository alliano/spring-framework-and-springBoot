package com.basicconfiguration.spring.core.helper.cilcularDependency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class CyclicA{

   private CyclicB cyclicB;

}