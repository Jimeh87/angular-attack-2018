package io.angularattack.loweredexpectations.chili.controllers;


import io.angularattack.loweredexpectations.chili.api.HelloDto;
import io.angularattack.loweredexpectations.chili.services.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping
    public HelloDto helloWorld() {

        return helloWorldService.helloWorld();
    }
}
