package io.angularattack.loweredexpectations.chili.services;

import io.angularattack.loweredexpectations.chili.api.HelloDto;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {


    public HelloDto helloWorld() {
        return new HelloDto()
                .setFirstName("Jon")
                .setLastName("Doe")
                .setMessage("Hello");
    }
}
