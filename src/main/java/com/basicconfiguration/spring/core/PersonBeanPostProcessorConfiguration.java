package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.basicconfiguration.spring.core.helper.Person;
import com.basicconfiguration.spring.core.processor.IdGeneratorPostProcessor;
import com.basicconfiguration.spring.core.processor.PrefixIdGeberatorPostProcessor;

@Configuration @Import(value = {
    Person.class,
    IdGeneratorPostProcessor.class,
    PrefixIdGeberatorPostProcessor.class
})
public class PersonBeanPostProcessorConfiguration { }
