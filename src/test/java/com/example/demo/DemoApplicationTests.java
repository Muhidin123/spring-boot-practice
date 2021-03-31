package com.example.demo;

import com.example.demo.controllers.GreetingController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturn200ResponseWithValidGetReqToroute(){
        GreetingController test = new GreetingController();
        ResponseEntity<String> result = test.testResponse();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

}
