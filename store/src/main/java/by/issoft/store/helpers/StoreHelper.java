package by.issoft.store.helpers;

import by.issoft.domain.Category;
import by.issoft.products.Product;
import by.issoft.store.Store;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class StoreHelper {

    Store store;

    public StoreHelper(Store store) {
        this.store = store;
    }

        public void fillStore() {

        RandomStorePopulator populator = new RandomStorePopulator();
        Map<Category, Integer> categoryMap = createCategoryMap();

        for (Map.Entry<Category, Integer> entry : categoryMap.entrySet()) {
            Category category = entry.getKey();
            Integer numberOfProducts = entry.getValue();
            for (int i = 0; i < numberOfProducts; i++) {

                Product product = new Product(populator.getProductName(category.getCategoryName()),
                        populator.getProductPrice(),
                        populator.getProductRate());
                category.addProductToCategory(product);
            }
            store.addCategoryToList(category);
        }
    }

    public static Map<Category, Integer> createCategoryMap() {
        Map<Category, Integer> categoryMap = new HashMap<>();

        Reflections reflections = new Reflections("by.issoft.domain.categories");

        Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);

        for (Class<? extends Category> type : subTypes) {
            try {
                Random random = new Random();
                categoryMap.put(type.getConstructor().newInstance(), random.nextInt( 10)+1);
            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return categoryMap;
    }
}
