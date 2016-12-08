package com.matic_test.grocery.products;

/**
 * Created by Roman on 12/6/2016.
 */
public abstract class AbsProduct implements IProduct {

    private float price;
    private String name;
    private String code;

    public AbsProduct(float price) {
        this.price = price;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    IProduct setName(String name) {
        this.name = name;
        return this;
    }

    IProduct setCode(String code) {
        this.code = code;
        return this;
    }
}
