package com.test.contorller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hi")
    public String getName(){
        return "hi sekhar ";
    }

    public  String feature1(){
        return  null;
    }

    public  String feature2(){
        return  null;
    }

    public  String  onefeature1(){
        return "1feature1";
    }
}
