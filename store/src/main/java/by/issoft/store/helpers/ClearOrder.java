package by.issoft.store.helpers;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ClearOrder extends TimerTask {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread name: " + Thread.currentThread().getName());
            CreateOrder.purchasedProductList.clear();
            System.out.println(CreateOrder.purchasedProductList);
            System.out.println("Order list was cleared");
        }
    }
}
