package com.example.demo;

import com.example.demo.controllers.GreetingController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
     void givenDataIsJson_whenDataIsPostedByPostForObject_thenResponseBodyIsNotNull()
            throws JSONException {

        //Url for the POST request to be sent
        String createPersonUrl = "http://localhost:8080/createPerson";

        RestTemplate restTemplate = new RestTemplate(); //new rest Template to test POST req
        HttpHeaders  headers = new HttpHeaders(); //
        headers.setContentType(MediaType.APPLICATION_JSON); //setting up headers to application/json other versions are possible
        JSONObject person = new JSONObject(); // building a JSON object to send with post req
        person.put("firstName", "Muhidin");
        person.put("lastName", "Muhidin");
        person.put("age", 25);
        person.put("address", "Salih bega Kuljuha");

        HttpEntity<String>request =
                new HttpEntity<>(person.toString(), headers);
        Person person2 =
                restTemplate.postForObject(createPersonUrl, request, Person.class); //The postForObject() method returns the response body as a String type.
//        JsonNode root = objectMapper.readTree(personResultAsJsonStr);


        Assertions.assertNotNull(person2);
        Assertions.assertNotNull(person2.getFirstName());
    }


    @Test
    void shouldReturn200ResponseWithValidGetReqToroute(){
        //returns 200 response if everything is setup properly
        GreetingController test = new GreetingController();
        ResponseEntity<String> result = test.testResponse();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

}
