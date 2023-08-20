package com.basicconfiguration.spring.core.application.ex;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Component(value = "foo-X-Person")
public class FooXPerson implements EnvironmentAware {
    
    private Person person;

    private Foo foo;

    private Environment environment;

    public FooXPerson(Foo foo, Person person) {
        this.person = person;
        this.foo = foo;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
