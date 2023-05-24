package com.imgai.kaka.controller;

import com.imgai.kaka.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final AnswerService service;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("answers",service.getAnswerList());
        System.out.println(service.getAnswerList());
        return "index";
    }
}
