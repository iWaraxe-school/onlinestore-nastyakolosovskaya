package by.issoft.store.helpers;

import by.issoft.products.Product;
import by.issoft.store.Store;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CreateOrder extends Thread {

    private final Store store = Store.getInstance();
    private Product purchasedProduct;
    public static CopyOnWriteArrayList<Product> purchasedProductList = new CopyOnWriteArrayList<>();

    @Override
    public void run() {
        while (true) {

            System.out.println("Thread name: " + Thread.currentThread().getName());
            purchasedProduct = Store.getInstance().getAllProducts().get(new Random().nextInt(10));

            System.out.println("Ordered product: " + purchasedProduct);
            purchasedProductList.add(purchasedProduct);
            System.out.println(purchasedProductList);
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(30));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}






