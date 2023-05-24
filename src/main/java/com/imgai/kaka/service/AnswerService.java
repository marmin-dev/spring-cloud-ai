package com.imgai.kaka.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imgai.kaka.entities.Answer;
import com.imgai.kaka.persistneces.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository repository;

    @Value("${openai.api.key}")
    private String apiKey;

    String endpoint = "https://api.openai.com/v1/chat/completions";


    public String createAnswer(String question) throws JsonProcessingException {
        // set header and body and request to open ai api
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        // set header properties
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(apiKey);
        // set body properties
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("model", "gpt-3.5-turbo");

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", question);


        List<Map<String, Object>> messages = new ArrayList<>();
        messages.add(message);

        requestBodyMap.put("messages", messages);
        requestBodyMap.put("temperature",1.5f);
        requestBodyMap.put("max_tokens",100);
        // parsing to String
        String requestBody = objectMapper.writeValueAsString(requestBodyMap);
        // set Http Entity
        HttpEntity<String> http = new HttpEntity<>(requestBody,httpHeaders);
        ResponseEntity entity = restTemplate.postForEntity(endpoint,http,String.class);
        // get response
        String response = entity.getBody().toString();
        //System.out.println(response);
        return response;
    }

    public String getContent(String data) throws JsonProcessingException {
        // get content data from openai Response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(data);
        String content = rootNode.get("choices").get(0).get("message").get("content").asText();
        return content;
    }


    @Transactional
    public String getAnswer(String str) throws JsonProcessingException {
        String data = createAnswer(str);
        String answer = getContent(data);
        Answer ans = new Answer();
        ans.setQuestion(str);
        ans.setAnswer(answer);
        return repository.save(ans).getAnswer();
    }


}
