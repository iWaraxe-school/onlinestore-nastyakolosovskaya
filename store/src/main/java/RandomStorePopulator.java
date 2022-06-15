import com.github.javafaker.Faker;
import by.issoft.categories.CategoryList;

public class RandomStorePopulator {


    private Faker faker = new Faker();

    public String getProductName(CategoryList category){
        switch (category) {
            case Bike:
                return faker.superhero().power();
            case Milk:
                return faker.food().ingredient();
            case Phone:
                return faker.pokemon().name();
            default:
                return "Unknown category";
        }
    }

    public Double getProductPrice (){
        return faker.number().randomDouble(2,1,1000);

    }

    public Double getProductRate(){
        return Double.valueOf(faker.number().numberBetween(0,10));
    }

}
