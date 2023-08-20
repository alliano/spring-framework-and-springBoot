package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.basicconfiguration.spring.core.application.FooApplication;
import com.basicconfiguration.spring.core.application.ex.FooXPerson;

@SpringBootTest(classes = FooApplication.class)
public class SpringconfogureApplicationTests {

	@Autowired
	private FooXPerson fooXPerson;

	@Test
	public void testFooxPerson() {
		Assertions.assertNotNull(fooXPerson);
		System.out.println(fooXPerson.getPerson().getName());
	}
}
