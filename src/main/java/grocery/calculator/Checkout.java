package com.matic_test.grocery.calculator;

import com.matic_test.grocery.EProductsRange;
import com.matic_test.grocery.products.IProduct;
import com.matic_test.grocery.products.ProductFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Roman on 12/6/2016.
 */
public class Checkout implements ICheckout{

    public static Checkout getInstance(IRule ... rules) {
        return new Checkout(new ArrayList<>(Arrays.asList(rules)));
    }

    private List<IProduct> cart = new ArrayList<>();
    private List<IProduct> receiptList;
    private List<IRule> rules = new ArrayList<>();
    private float total = -1;
    private float originalSum;

    public Checkout (List<IRule> rules){
        this.rules = rules;
    }

    public void scan(EProductsRange type){
        cart.add(ProductFactory.getProduct(type));
        total = originalSum = -1;
    }

    public void scan(IProduct product){
        cart.add(product);
        total = originalSum = -1;
    }

    public void checkout(){
        if (total > 0) return;
        receiptList = new ArrayList<>(cart.size());
        receiptList.addAll(cart.stream().map(ProductFactory::cloneProduct).collect(Collectors.toList()));
        for (IRule rule :rules) {
            rule.apply(this);
        }
        receiptList.forEach(p -> total += p.getPrice());
        cart.forEach(p -> originalSum += p.getPrice());
    }

    public float getTotal() {
        if (total < 0) throw new RuntimeException("checkout is needed");
        return total;
    }

    public void printReceipt(){
        if (total < 0) throw new RuntimeException("checkout is needed");
        receiptList.forEach(p -> System.out.println(String.format("%-15s --- %6.2f",p.getName() ,p.getPrice())));
        System.out.println(String.format("### %-10s - %-5.2f","ORIGINAL",originalSum));
        System.out.println(String.format("### %-10s - %5.2f","TOTAL",total));
    }

    @Override
    public List<IProduct> getReceiptProds() {
        return receiptList;
    }

    @Override
    public List<IRule> getRules() {
        return rules;
    }
}
