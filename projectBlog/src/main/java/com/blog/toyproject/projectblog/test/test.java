package com.blog.toyproject.projectblog.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping("/")
    public String hello(){
        System.out.println("helloworld");
        return "<h1>hello world!!!</h1>";
    }


}
