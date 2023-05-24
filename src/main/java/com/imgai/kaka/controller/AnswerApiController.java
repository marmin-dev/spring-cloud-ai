package com.imgai.kaka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.imgai.kaka.dtos.AnswerResponseDto;
import com.imgai.kaka.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AnswerApiController {

    private final AnswerService service;

    @GetMapping("/create/{question}")
    public ResponseEntity<String> getAnswer(@PathVariable String question) throws JsonProcessingException {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAnswer(question));
    }

    @GetMapping("/create")
    public ResponseEntity<List<AnswerResponseDto>> getList(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAnswerList());
    }

}
