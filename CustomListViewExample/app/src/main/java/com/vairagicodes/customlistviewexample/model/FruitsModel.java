package com.vairagicodes.customlistviewexample.model;

public class FruitsModel {

    private String fruitTitle;
    private int fruitImage;

    public FruitsModel(String fruitTitle, int fruitImage) {
        this.fruitTitle = fruitTitle;
        this.fruitImage = fruitImage;
    }

    public String getFruitTitle() {
        return fruitTitle;
    }

    public void setFruitTitle(String fruitTitle) {
        this.fruitTitle = fruitTitle;
    }

    public int getFruitImage() {
        return fruitImage;
    }

    public void setFruitImage(int fruitImage) {
        this.fruitImage = fruitImage;
    }
}
