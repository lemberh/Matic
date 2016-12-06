package com.company.grocery.products;

import com.company.grocery.EProductsRange;

/**
 * Created by Roman on 12/6/2016.
 */
public interface IProduct {
    EProductsRange getId();
    float getPrice();
    void setPrice(float price);
    String getCode();
    String getName();
}
