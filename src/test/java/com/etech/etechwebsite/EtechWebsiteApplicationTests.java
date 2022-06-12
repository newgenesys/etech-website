package com.etech.etechwebsite;

import com.etech.etechwebsite.service.SecurityConfig;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = EtechWebsiteApplication.class)
class EtechWebsiteApplicationTests {

    @Autowired
    private EtechWebsiteApplication etechwebsiteapp;

    @Autowired
    private SecurityConfig securityConfig;

    @Test
    void contextLoads() {
        assertThat(etechwebsiteapp).isNotNull();
        assertThat(securityConfig).isNotNull();
    }

}
