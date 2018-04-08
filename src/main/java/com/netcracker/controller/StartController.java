package com.netcracker.controller;

import com.netcracker.infrastructure.services.ServiceStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
