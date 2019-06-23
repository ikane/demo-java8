package com.example.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MyApi {

    @GetMapping(path = "/home")
    public String result(@RequestParam List<String> params) {
        return "hello " + params.toString();
    }
}
