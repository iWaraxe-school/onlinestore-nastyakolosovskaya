package by.issoft.store.helpers;

import by.issoft.store.Store;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ClearOrder extends TimerTask {

    private final Store store = Store.SingletonEnum.INSTANCE.getValue();
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread name: " + Thread.currentThread().getName());
            store.getPurchasedProductList().clear();
            System.out.println(store.getPurchasedProductList());
            System.out.println("Order list was cleared");
        }
    }
}
