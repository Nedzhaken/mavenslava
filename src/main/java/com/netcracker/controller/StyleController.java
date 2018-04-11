package com.netcracker.controller;

import com.netcracker.entity.Style;
import com.netcracker.infrastructure.services.ServiceStyle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/style/")
@Api(value = "StyleControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class StyleController {


    @Autowired
    public ServiceStyle StyleService;

    @GetMapping("")
    public String index() {
        return "work with styles";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello, your work with styles";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public void insert(@RequestBody Style jsonString){
        StyleService.insert(jsonString);
    }

    @RequestMapping(value = "loadall", method = RequestMethod.GET)
    public List<Style> loadAll(){
        List<Style> newList = StyleService.loadAll();
        return newList;
    }

    @RequestMapping(value="{name}", method = RequestMethod.GET)
    @ApiOperation("Gets the Style with specific name")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Style.class)})
    public  List<Style> loadByStyleName(@PathVariable("name") String name){
        return StyleService.loadByStyleName(name);
    }

    @RequestMapping(value="styleid/{id}", method = RequestMethod.GET)
    public  Style loadByStyleID(@PathVariable("id") String id){
        return StyleService.loadByStyleID(id);
    }

    @RequestMapping(value = "loadallfull", method = RequestMethod.GET)
    public List<Style> loadAllAuthors(){
        List<Style> newList = StyleService.loadAllFull();
        return newList;
    }

    @RequestMapping(value="stylenamefull/{name}", method = RequestMethod.GET)
    public  List<Style> loadByStyleNameFull(@PathVariable("name") String name){
        return StyleService.loadByStyleNameFull(name);
    }

    @RequestMapping(value="styleidfull/{id}", method = RequestMethod.GET)
    public  Style loadByStyleIDFull(@PathVariable("id") String id){
        return StyleService.loadByStyleIDFull(id);
    }

    @RequestMapping(value = "deleteall", method = RequestMethod.DELETE)
    public void deleteAll(){
        StyleService.deleteAll();
    }

    @RequestMapping(value = "deletename/{name}", method = RequestMethod.DELETE)
    public void deleteStyleName(@PathVariable ("name") String name){
        StyleService.deleteStyleName(name);
    }

    @RequestMapping(value = "deleteid/{id}", method = RequestMethod.DELETE)
    public void deleteStyleId(@PathVariable ("id") String id){
        StyleService.deleteStyleId(id);
    }
}
