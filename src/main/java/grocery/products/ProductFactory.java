package com.matic_test.grocery.products;

import com.matic_test.grocery.EProductsRange;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Roman on 12/6/2016.
 */
public class ProductFactory {
    private static final float AppleJuicePrice = 7.25f;
    private static final float FruitTeaPrice = 3.11f;
    private static final float CoffeePrice = 11.23f;
    private static final float StrawberriesPrice = 5;

    public static IProduct cloneProduct(IProduct product){
        IProduct clone = getProduct(product.getId(),product.getName());
        clone.setPrice(product.getPrice());
        return clone;
    }

    public static IProduct getProduct(EProductsRange type,String name){
        return ((AbsProduct)getProduct(type)).setName(name);
    }

    public static IProduct getProduct(EProductsRange type){
        switch (type){
            case APPLE_JUICE:
                return new AppleJuice(AppleJuicePrice).setName("Apple Juice");
            case FRUIT_TEE:
                return new FruitTea(FruitTeaPrice).setName("Fruit Tea");
            case COFFEE:
                return new Coffee(CoffeePrice).setName("Coffee");
            case STRAWBERRIES:
                return new Strawberries(StrawberriesPrice).setName("Strawberries");
            default:
                throw new NotImplementedException();
        }
    }

}
