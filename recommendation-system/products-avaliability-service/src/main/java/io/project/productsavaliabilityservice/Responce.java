package io.project.productsavaliabilityservice;

public class Responce {
    String text;

    public Responce(){}

    public Responce(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
