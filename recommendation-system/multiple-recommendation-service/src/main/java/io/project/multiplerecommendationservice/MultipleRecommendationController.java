package io.project.multiplerecommendationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;


@RestController
public class MultipleRecommendationController {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(path = "/complexrecommended")
    public Responce getcomplexRecommendation() throws IOException {
        Responce responce = webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8000/model")
                .retrieve()
                .bodyToMono(Responce.class)
                .block();
        return responce;
    }
}
