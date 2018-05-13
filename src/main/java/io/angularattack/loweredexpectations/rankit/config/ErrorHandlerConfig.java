package io.angularattack.loweredexpectations.rankit.config;

import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Configuration
public class ErrorHandlerConfig {

    @Bean
    ErrorViewResolver supportPathBasedLocationStrategyWithoutHashes() {
        return (HttpServletRequest request, HttpStatus status, Map<String, Object> model) ->
                status == HttpStatus.NOT_FOUND
                        ? new ModelAndView("index.html", Collections.emptyMap(), HttpStatus.OK)
                        : null;
    }
}
