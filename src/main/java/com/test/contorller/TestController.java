package com.test.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //get api with end point hi
    @GetMapping("/hi")
    public String getName(){
        return "hi sekhar ";
    }
}
