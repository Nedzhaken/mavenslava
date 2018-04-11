package com.netcracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    @GetMapping("")
    public String index() {
        return "hello";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
