package by.issoft.store.Commands;

import by.issoft.store.helpers.CreateOrder;


public class OrderProduct implements StoreCommand{

     private final CreateOrder createOrder = new CreateOrder();

    @Override
    public void execute()  {

           createOrder.start();
        try {
            createOrder.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
