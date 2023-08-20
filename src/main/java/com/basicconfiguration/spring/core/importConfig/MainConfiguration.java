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
