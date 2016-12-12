package grocery.products;

import grocery.EProductsRange;

/**
 * Created by Roman on 12/6/2016.
 */
public class Strawberries extends AbsProduct {

    public Strawberries(float price) {
        super(price);
    }

    @Override
    public EProductsRange getId() {
        return EProductsRange.STRAWBERRIES;
    }
}
