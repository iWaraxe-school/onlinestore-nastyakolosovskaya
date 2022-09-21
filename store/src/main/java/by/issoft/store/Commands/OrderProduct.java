package by.issoft.store.Commands;

import by.issoft.store.helpers.CreateOrder;


public class OrderProduct implements StoreCommand{


    @Override
    public void execute()  {

        CreateOrder createOrder = new CreateOrder();
        createOrder.start();
          }
}
