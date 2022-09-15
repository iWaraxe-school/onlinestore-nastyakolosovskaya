package by.issoft.store.helpers;

import by.issoft.products.Product;
import by.issoft.store.Store;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class CreateOrder extends Thread {
    private final Store store = Store.getInstance();

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            Thread.currentThread().setName("orderThread");
            System.out.println("Thread name: " + Thread.currentThread().getName());
            Product purchasedProduct = store.getAllProducts().get(new Random().nextInt(10));

            System.out.println("Ordered product: " + purchasedProduct);
            store.getPurchasedProductList().add(purchasedProduct);
            System.out.println(store.getPurchasedProductList());
            try {
                TimeUnit.SECONDS.sleep(new Random().nextInt(30));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }
        }
    }
}






