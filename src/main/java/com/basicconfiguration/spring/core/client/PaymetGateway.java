package com.basicconfiguration.spring.core.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * kita analogikan kelas ini sebagai third party liberary
 * dan kita tidak memiliki kendali untuk menambahkan annotasi
 * @Component pada class ini
 */
@NoArgsConstructor
@Setter @Getter @AllArgsConstructor
public class PaymetGateway {
    
    private String endpoint;

    private String publicKey;

    private String privateKey;
}
