package com.company.grocery.calculator;

import com.company.grocery.products.IProduct;

import java.util.List;

/**
 * Created by Roman on 12/6/2016.
 */
public interface ICheckout {
    List<IProduct> getReceiptProds();
    List<IRule> getRules();
}
