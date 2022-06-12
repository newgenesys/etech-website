package com.etech.etechwebsite;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@Controller
@EnableAutoConfiguration
//@Route("")
public class EtechWebsiteApplication extends ServletInitializer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(EtechWebsiteApplication.class);//.run(EtechWebsiteApplication.class, args);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8088"));
        app.run(args);
    }

//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }
//    
//    @RequestMapping("/login")
//    String login() {
//        return "Hello World! Login";
//    }

}
