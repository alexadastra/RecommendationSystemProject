package io.project.productsavaliabilityservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class ProductsAvailabilityController {
    @Autowired
    private WebClient.Builder webClientBuilder;

    ProductsConfigurer configurer = new ProductsConfigurer();
    @GetMapping(path = "/available")
    List<Responce> getAvailable(){
        ResponseWrapper response = webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8084/")
                .retrieve()
                .bodyToMono(ResponseWrapper.class).block();

        return configurer.getAvailableProducts(response.getResponsesList());
    }

}
