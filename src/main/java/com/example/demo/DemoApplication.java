package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@CrossOrigin //CAN BE USED TO ENABLE CROSS ORIGIN
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    //USING THIS METHOD WILL ENABLE CROSS ORIGIN
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/").allowedOrigins("http://localhost:8080", "http://localhost:3000");
//            }
//        };
//    }



}
