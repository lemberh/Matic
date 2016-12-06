package com.company.grocery.calculator;

import com.company.grocery.products.IProduct;

import java.util.List;

/**
 * Created by Roman on 12/6/2016.
 */

public interface IRule {
    void apply(ICheckout co);
}
