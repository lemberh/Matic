package com.matic_test.grocery.calculator;

import com.matic_test.grocery.products.IProduct;

import java.util.List;

/**
 * Created by Roman on 12/6/2016.
 */
public interface ICheckout {
    List<IProduct> getReceiptProds();
    List<IRule> getRules();
}
