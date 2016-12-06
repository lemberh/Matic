package com.company.grocery.products;

import com.company.grocery.EProductsRange;

/**
 * Created by Roman on 12/6/2016.
 */
public class AppleJuice extends AbsProduct {

    public AppleJuice(float price) {
        super(price);
    }

    @Override
    public EProductsRange getId() {
        return EProductsRange.APPLE_JUICE;
    }
}
