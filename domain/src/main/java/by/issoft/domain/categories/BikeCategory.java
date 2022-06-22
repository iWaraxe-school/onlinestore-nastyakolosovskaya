package by.issoft.domain.categories;

import by.issoft.domain.Category;

public class BikeCategory extends Category {

    public BikeCategory() {
        super("Bike");
    }

    @Override
    public String getCategoryName() {
        return "Bike";
    }
}
