package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.basicconfiguration.spring.core.service.MerchentServiceImpl;

/**
 * Inheritance
 * saat kita meng akses Bean, kita bisa langsung menyebut tipe class bean nya tesebut atau 
 * bisa juga dengan parent Class/parent interface Bean 
 * misal jika kita memiliki sebuah interface bernama MerchentService lalu kita memiliki Bean 
 * dengan object implementasi class nya MerchantServiceimpl, maka untuk mengakses bean nya 
 * kita tidak hanya bisa menggunakan tipe MerchanServiceImpl namun jugta bsia dengan MerchentService
 * Namun perlu ber hati hati jika misal MerchentService memiliki banyak bean turunann, pastikan
 * tidak terjadi error duplicate;  
 */

@Component
@Import(value = {MerchentServiceImpl.class})
public class InheritanceConfiguration {
   
}
