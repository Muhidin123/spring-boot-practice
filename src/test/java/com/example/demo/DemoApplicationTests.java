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
    public void givenDataIsJson_whenDataIsPostedByPostForObject_thenResponseBodyIsNotNull()
            throws IOException, JSONException {
        String createPersonUrl = "http://localhost:8080/createPerson";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders  headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject person = new JSONObject();
        person.put("firstName", "Muhidin");
        person.put("lastName", "Muhidin");
        person.put("age", 25);
        person.put("address", "Salih bega Kuljuha");
        person.put("id", 1);

        HttpEntity<String> request =
                new HttpEntity<>(person.toString(), headers);
        String personResultAsJsonStr =
                restTemplate.postForObject(createPersonUrl, request, String.class);
        JsonNode root = objectMapper.readTree(personResultAsJsonStr);


        Assertions.assertNotNull(personResultAsJsonStr);
        Assertions.assertNotNull(root);
        Assertions.assertNotNull(root.path("firstName").asText());
    }





    @Test
    void shouldReturn200ResponseWithValidGetReqToroute(){
        GreetingController test = new GreetingController();
        ResponseEntity<String> result = test.testResponse();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(200, result.getStatusCodeValue());
    }

}
