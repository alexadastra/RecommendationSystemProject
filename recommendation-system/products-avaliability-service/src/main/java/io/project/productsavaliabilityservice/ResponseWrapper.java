package io.project.productsavaliabilityservice;

import java.util.ArrayList;

public class ResponseWrapper {
    ArrayList<Responce> responsesList;

    public ResponseWrapper() {}

    public ResponseWrapper(ArrayList<Responce> responsesList) {
        this.responsesList = responsesList;
    }

    public ArrayList<Responce> getResponsesList() {
        return responsesList;
    }

    public void setResponsesList(ArrayList<Responce> responsesList) {
        this.responsesList = responsesList;
    }
}
