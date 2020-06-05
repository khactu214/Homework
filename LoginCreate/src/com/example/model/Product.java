package com.example.model;

public class Product {
    private int id;
    private String name;
    private String pro;

    public Product(int id, String name, String pro){
        this.id = id;
        this.name = name;
        this.pro = pro;
    }
    public Product(){
    }
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPro() {
        return pro;
    }
    public void setPro(String pro) {
        this.pro = pro;
    }
}
