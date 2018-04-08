package com.netcracker.controller;

import com.netcracker.entity.Style;
import com.netcracker.infrastructure.services.ServiceStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/style")
public class StyleController {


    @Autowired
    public ServiceStyle StyleService;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "loadall", method = RequestMethod.GET)
    public List<Style> loadAll(){
        List<Style> newList = StyleService.loadAll();
        return newList;
    }

    @RequestMapping(value="{name}", method = RequestMethod.GET)
    public  List<Style> loadByStyleName(@PathVariable("name") String name){
                return StyleService.loadByStyleName(name);
    }

    @RequestMapping(value = "loadallfull", method = RequestMethod.GET)
    public List<Style> loadAllAuthors(){
        List<Style> newList = StyleService.loadAllFull();
        return newList;
    }
}
