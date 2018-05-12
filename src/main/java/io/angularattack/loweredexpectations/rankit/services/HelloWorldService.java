package io.angularattack.loweredexpectations.rankit.services;

import io.angularattack.loweredexpectations.rankit.api.HelloDto;
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
