package com.example.backend.controller;

import com.example.backend.dto.Protocol;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private ObjectMapper mapper = new ObjectMapper();

    @CrossOrigin("*")
    @GetMapping("/protocol")
    public String getProtocol(HttpServletRequest req) throws JsonProcessingException {
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("info", String.format("PROTOCOL : [%s]\nCLIENT_HOST : [%s]", req.getProtocol(), req.getRemoteAddr()));
        return mapper.writeValueAsString(jsonMap);
    }

    @CrossOrigin("*")
    @GetMapping("/image-large")
    public String getImageLarge(HttpServletRequest req) throws IOException {
        Long start = new Date().getTime();
        Map<String, String> jsonMap = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(new ClassPathResource("img/sample_large.jpg").getFile())) {
            jsonMap.put("base64", "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(fis.readAllBytes()));
        }
        Long end = new Date().getTime();
        jsonMap.put("info", String.format("API_PATH : [/image-large] EXECUTE_TIME : [%d ms]", end - start));
        return mapper.writeValueAsString(jsonMap);
    }

    @CrossOrigin("*")
    @GetMapping("/image-small")
    public String getImageSmall(HttpServletRequest req) throws IOException {
        Long start = new Date().getTime();
        Map<String, String> jsonMap = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(new ClassPathResource("img/sample_small.jpg").getFile())) {
            jsonMap.put("base64", "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(fis.readAllBytes()));
        }
        Long end = new Date().getTime();
        jsonMap.put("info", String.format("API_PATH : [/image-small] EXECUTE_TIME : [%d ms]", end - start));
        return mapper.writeValueAsString(jsonMap);
    }
}
