package com.kgisl.demo1.entity;

public class Bike {
    private int bikeId;
    private String brand;
    private String model;
    private float price;
    public Bike(int bikeId, String brand, String model, float price) {
        this.bikeId = bikeId;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public int getBikeId() {
        return bikeId;
    }
    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    
}
