package by.issoft.store.helpers;

import by.issoft.domain.Category;
import by.issoft.products.Product;
import by.issoft.store.Store;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class StoreHelper {

    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }


    public List<Product> fillStore(Category category){

        List<Product> productList = new ArrayList<>();
        RandomStorePopulator populator = new RandomStorePopulator();

        //does not work as expected
        productList.add(new Product(populator.getProductName("Milk"),
                   populator.getProductPrice(),
                   populator.getProductRate()));


        return productList;

    }

    public static Map<Category, Integer> createCategoryMap() {
        Map<Category, Integer> categoryToPut = new HashMap<>();

        Reflections reflections = new Reflections("com.issoft.domain.categories");

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type : subTypes) {
            try {
                Random random = new Random();
                categoryToPut.put(type.getConstructor().newInstance(), random.nextInt(10));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return categoryToPut;
    }


}
