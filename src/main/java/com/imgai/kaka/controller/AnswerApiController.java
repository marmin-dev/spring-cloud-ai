package com.imgai.kaka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.imgai.kaka.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AnswerApiController {

    private final AnswerService service;

    @PostMapping("/create")
    public ResponseEntity<String> getAnswer(@RequestBody String question) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAnswer(question));
    }

}
