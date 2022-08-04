package by.issoft.store;


import by.issoft.domain.Category;
import by.issoft.products.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private List<Category> categoryList = new ArrayList<>();

    public List<Category> getCategoryList() {
        return categoryList;
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






