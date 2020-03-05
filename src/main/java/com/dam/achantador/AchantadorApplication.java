package com.dam.achantador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class AchantadorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AchantadorApplication.class, args);
    }

}
