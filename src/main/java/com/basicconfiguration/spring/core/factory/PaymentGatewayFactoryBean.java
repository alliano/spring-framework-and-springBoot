package com.basicconfiguration.spring.core.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.client.PaymetGateway;

@Component(value = "PaymentGateway")
public class PaymentGatewayFactoryBean implements FactoryBean<PaymetGateway> {

    /**
     * method ini nantinya kan membuatkan Object Bean PaymentGateway
     * jika disini kita ingin melakukan depoendency Injection, kita dapat melakukanya dengan
     * bisa menggunakan construcotr injection, atau Seter Injectionm ataupun method parameter Injection
     */
    @Override
    public PaymetGateway getObject() throws Exception {
        PaymetGateway paymetGateway = new PaymetGateway();
        paymetGateway.setEndpoint("https://examplePaymentGateway.com/req");
        paymetGateway.setPublicKey("public_key");
        paymetGateway.setPrivateKey("private_key");
        return paymetGateway;
    }

    @Override
    public Class<?> getObjectType() {
        return PaymetGateway.class;
    } 
}
