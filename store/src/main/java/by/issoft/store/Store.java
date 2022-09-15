package by.issoft.store;


import by.issoft.domain.Category;
import by.issoft.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class Store {

    private final List<Category> categoryList = new ArrayList<>();
    private final CopyOnWriteArrayList<Product> purchasedProductList = new CopyOnWriteArrayList<>();

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public CopyOnWriteArrayList<Product> getPurchasedProductList() {
        return purchasedProductList;
    }

    public Store(){
    }

    private static class SingletonHelper{
        private static final Store STORE_INSTANCE = new Store();
    }
       public static Store getInstance(){
          return SingletonHelper.STORE_INSTANCE;
        }

    public void addCategoryToList(Category category) {
        categoryList.add(category);
    }

    public List<Product> getAllProducts() {
        return categoryList.stream()
                .flatMap(category -> category.getProductList().stream())
                .collect(Collectors.toList());
    }

    public void printStore() {
        System.out.println("---Welcome to Online Store!---");
        for (Category category : categoryList) {
            category.printCategory();
        }
    }
}






