package com.rp4.hotelaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelariaApplication {

    public static void main(String[] args) {

        SpringApplication.run(HotelariaApplication.class, args);
    }
}
