package com.api.udemuz;

import com.api.udemuz.constant.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ElementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElementApplication.class, args);
    }

}
