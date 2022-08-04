package by.issoft.store.helpers.comparators;

import by.issoft.products.Product;

import java.util.Comparator;

public class ProductNameComparator implements Comparator<Product> {

    public int compare(Product product1, Product product2){
        return product1.getName().compareTo(product2.getName());
    }
}
