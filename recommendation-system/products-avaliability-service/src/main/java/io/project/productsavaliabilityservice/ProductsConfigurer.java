package io.project.productsavaliabilityservice;

import java.util.ArrayList;

public class ProductsConfigurer {
    ArrayList<String> taboo;

    ProductsConfigurer(){
        taboo = new ArrayList<>();
        taboo.add("shit");
        taboo.add("fuck");
    }

    ArrayList<Responce> getAvailableProducts(ArrayList<Responce> data){
        ArrayList<Responce> result= new ArrayList<>();

        for(var item : data){
            boolean acceptable = true;
            for(var word : taboo){
                if (item.text.contains(word)){
                    acceptable = false;
                    break;
                }
            }
            if(acceptable) {
                result.add(item);
            }
        }
        return result;
    }
}
