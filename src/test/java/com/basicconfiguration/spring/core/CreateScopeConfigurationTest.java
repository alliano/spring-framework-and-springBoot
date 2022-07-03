// package com.basicconfiguration.spring.core;

// import org.junit.jupiter.api.Assertions;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// import com.basicconfiguration.spring.core.helper.Foo;


// public class CreateScopeConfigurationTest {
   
//    private ApplicationContext context;

//    @BeforeEach
//    void setUp(){
//       this.context = new AnnotationConfigApplicationContext(CreateScopeConfiguration.class);
//    }

//    @Test
//    void testDoubleton(){
//       Foo foo1 = this.context.getBean("foo",Foo.class);
//       Assertions.assertNotNull(foo1);
//    }
// }
