package by.issoft.store.Commands;

import by.issoft.store.helpers.CreateOrder;


public class OrderProduct implements StoreCommand{

     private  CreateOrder createOrder = new CreateOrder();

    @Override
    public void execute()  {
         createOrder.start();
    }
}
