package by.issoft.domain.categories;

import by.issoft.domain.Category;

public class BikeCategory extends Category {

    public BikeCategory() {
        super("Bike category");
    }

    @Override
    public String getCategoryName() {
        return "Bike category";
    }
}
