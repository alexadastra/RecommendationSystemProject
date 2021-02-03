package io.project.recommendationcatalogueservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class RecommendationCatalogueController {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping(path = "/recommended")
    public String getRecommendations() {

        Responce responce = webClientBuilder
                .build()
                .get()
                .uri("http://multiple-recommendation/complexrecommended")
                .retrieve()
                .bodyToMono(Responce.class).block();
        return responce.getText();
    }
}
