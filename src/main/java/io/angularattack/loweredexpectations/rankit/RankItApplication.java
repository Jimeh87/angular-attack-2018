package io.angularattack.loweredexpectations.rankit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RankItApplication {

	public static void main(String[] args) {
		SpringApplication.run(RankItApplication.class, args);
	}

}