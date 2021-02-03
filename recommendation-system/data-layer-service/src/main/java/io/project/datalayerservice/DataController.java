package io.project.datalayerservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DataController {
    @GetMapping(path = "/")
    ResponseWrapper getAvailable(){
        ArrayList<Responce> availableItems =  new ArrayList<>();
        availableItems.add(new Responce("I am response!!!"));
        availableItems.add(new Responce("I am response too!!!"));
        availableItems.add(new Responce("I am response 3!!!"));
        availableItems.add(new Responce("I am response 4!!!"));
        availableItems.add(new Responce("I am fucking response 5!!!"));
        availableItems.add(new Responce("I am shit shit shit!!!"));
        availableItems.add(new Responce("I am response 6!!!"));

        return new ResponseWrapper(availableItems);
    }
}
