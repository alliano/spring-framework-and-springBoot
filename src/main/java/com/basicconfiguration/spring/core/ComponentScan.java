package com.basicconfiguration.spring.core;

// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * import configuration satu per satu tyducklah manusiawi heheh karna kita bisa memecah
 * Configuration Class menjadi banyak Class 
 * namun semakin lama, pasti applikasi kita akan semakin besar dan secara otomatis 
 * configuration class makin banyak 
 * melakukan impoert satu persatu tidaklah keren:v jika terlalu banyak 
 * untung nya spring mempunyai fitur componentScan, yang mna kita bisa secara otomatis 
 * mengimport Configuration di sebuah package dan sub packagenya secara otomatis
 * untuk melakukanya kita bisa menggunakan annotation @componentScan({})
 */

// @ComponentScan(basePackages = "package com.basicconfiguration.spring.core.componentScan")
@Configuration
public class ComponentScan {
   
}
