package by.issoft.store.helpers;

import by.issoft.store.Store;

import java.util.TimerTask;

public class ClearOrder extends TimerTask {

    private final Store store = Store.getInstance();
    @Override
    public void run() {

            System.out.println("Thread name: " + Thread.currentThread().getName());
            store.getPurchasedProductList().clear();
            System.out.println(store.getPurchasedProductList());
            System.out.println("Order list was cleared");

        }
    }

