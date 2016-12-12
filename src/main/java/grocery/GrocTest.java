package grocery;

import grocery.calculator.Checkout;
import grocery.calculator.IRule;
import grocery.products.IProduct;
import grocery.products.ProductFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Roman on 12/6/2016.
 */
public class GrocTest {

    public static void main (String[] args){
        IRule ftRule = co -> {
            List<IProduct> freeTee = co.getReceiptProds().stream().filter(p -> p.getId() == EProductsRange.FRUIT_TEE).
                    map(p -> {
                        IProduct prod = ProductFactory.getProduct(EProductsRange.FRUIT_TEE,"FREE Fruit Tee");
                        prod.setPrice(0);
                        return prod;
                    }).collect(Collectors.toList());
            co.getReceiptProds().addAll(freeTee);
        };
        IRule sbRule = co -> {
            long sbCount = co.getReceiptProds().stream().filter(p -> p.getId() == EProductsRange.STRAWBERRIES).count();
            if (sbCount > 3) {
                co.getReceiptProds().stream().filter(p -> p.getId() == EProductsRange.STRAWBERRIES).forEach(p -> p.setPrice(4.5f));
            }
        };
        IRule totalDiscount = co -> {
            final float[] total = {0};
            co.getReceiptProds().forEach(p -> total[0] +=p.getPrice());
            if (total[0] > 35){
                co.getReceiptProds().forEach(p -> p.setPrice(p.getPrice() * 0.55f));
            }
        };
        Checkout co = Checkout.getInstance(ftRule,sbRule,totalDiscount);
        co.scan(EProductsRange.FRUIT_TEE);
        co.scan(EProductsRange.APPLE_JUICE);
        co.scan(EProductsRange.COFFEE);
        co.scan(EProductsRange.STRAWBERRIES);
//        co.printReceipt();
        co.checkout();
        co.printReceipt();
        System.out.println("Add Some more products\n");
        co.scan(EProductsRange.STRAWBERRIES);
        co.scan(EProductsRange.STRAWBERRIES);
        co.scan(EProductsRange.STRAWBERRIES);
        co.checkout();
        co.printReceipt();
    }
}
