package com.matic_test.grocery.products;

import com.matic_test.grocery.EProductsRange;

/**
 * Created by Roman on 12/6/2016.
 */
public class FruitTea extends AbsProduct {

    public FruitTea(float price) {
        super(price);
    }

    @Override
    public EProductsRange getId() {
        return EProductsRange.FRUIT_TEE;
    }

}