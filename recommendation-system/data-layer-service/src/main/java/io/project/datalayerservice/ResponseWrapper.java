package io.project.datalayerservice;

import java.util.ArrayList;

public class ResponseWrapper {
    ArrayList<Responce> responsesList;

    public ResponseWrapper() {}

    public ResponseWrapper(ArrayList<Responce> responcesList) {
        this.responsesList = responcesList;
    }

    public ArrayList<Responce> getResponsesList() {
        return responsesList;
    }

    public void setResponsesList(ArrayList<Responce> responsesList) {
        this.responsesList = responsesList;
    }
}
