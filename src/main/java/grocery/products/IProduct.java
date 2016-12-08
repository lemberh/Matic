package com.matic_test.grocery.products;

import com.matic_test.grocery.EProductsRange;

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
