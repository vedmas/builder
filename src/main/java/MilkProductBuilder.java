public class MilkProductBuilder extends ProductBuilder {

    @Override
    public ProductBuilder buildName() {
        product.setName("Milk");
        return this;
    }

    @Override
    public ProductBuilder buildPrice() {
        product.setPrice(15);
        return this;
    }

    @Override
    public ProductBuilder buildCategory() {
        product.setCategory("food");
        return this;
    }

    @Override
    public ProductBuilder buildCalorific() {
        product.setCalorific(100);
        return this;
    }

    @Override
    public ProductBuilder buildSize() {
        return null;
    }

    @Override
    public ProductBuilder buildSeasonality() {
        return null;
    }
}
