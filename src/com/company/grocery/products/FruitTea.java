package com.company.grocery.products;

import com.company.grocery.EProductsRange;

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
