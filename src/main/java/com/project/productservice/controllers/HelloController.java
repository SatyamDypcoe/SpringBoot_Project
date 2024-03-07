package com.project.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/say/{name}/{name1}/{times}")
    public String sayHello(@PathVariable("name") String name,
                           @PathVariable("times") int times, @PathVariable("name1") String name1){
        String answer = "";
        for(int i = 0; i < times; ++i){
            answer += name + " and " + name1 + " Hello";
            answer += "<br>";
            answer += "<br>";
        }
        return answer;
    }
}
