package com.example.writeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient//registry eureka server
public class WriteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WriteServiceApplication.class, args);
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        //autowired 하기 위해 Bean 생성
        return new BCryptPasswordEncoder();
    }
}
