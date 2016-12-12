package grocery.products;

import grocery.EProductsRange;

/**
 * Created by Roman on 12/6/2016.
 */
public class Coffee extends AbsProduct {

    public Coffee(float price) {
        super(price);
    }

    @Override
    public EProductsRange getId() {
        return EProductsRange.COFFEE;
    }
}
