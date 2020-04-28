package builder;

public class SlippersProductBuilder extends ProductBuilder {

    @Override
    public ProductBuilder buildName() {
        product.setName("Slippers");
        return this;
    }

    @Override
    public ProductBuilder buildPrice() {
        product.setPrice(25);
        return this;
    }

    @Override
    public ProductBuilder buildCategory() {
        product.setCategory("Shoes");
        return this;
    }

    @Override
    public ProductBuilder buildCalorific() {
        return null;
    }

    @Override
    public ProductBuilder buildSize() {
        product.setSize(42);
        return this;
    }

    @Override
    public ProductBuilder buildSeasonality() {
        product.setSeasonality("Summer");
        return this;
    }
}
