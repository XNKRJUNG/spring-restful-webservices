package com.cyrus.rest.webservices.restfulwebservices.helloworld.controller;

import com.cyrus.rest.webservices.restfulwebservices.helloworld.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

//    @RequestMapping(method= RequestMethod.GET, path = "/hello-world")
//    public String helloWorld(){
//        return "Hello World";
//    }

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanWPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s",name));
    }
}
