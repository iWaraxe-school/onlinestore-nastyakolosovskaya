package by.issoft.domain.categories;

import by.issoft.domain.Category;

public class PhoneCategory extends Category {

    public PhoneCategory() {
        super("Phone category");
    }

    @Override
    public String getCategoryName() {
        return "Phone category";
    }
}
