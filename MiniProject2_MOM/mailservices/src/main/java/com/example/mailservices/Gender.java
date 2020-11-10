package com.example.mailservices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Gender {



    public static String getGender(String name){
        RestTemplate restTemplate = new RestTemplate();
        String endPointGetGender = "http://www.thomas-bayer.com/restnames/name.groovy?name={id}";

        ResponseEntity<String> string = restTemplate.getForEntity(endPointGetGender, String.class, name);

        return string.getBody();
    }
}


