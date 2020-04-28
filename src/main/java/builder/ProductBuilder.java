package builder;

public abstract class ProductBuilder {
    protected Product product;

    public Product getProduct() {
        return product;
    }

    public ProductBuilder createNewProduct() {
        product = new Product();
        return this;
    }

    public abstract ProductBuilder buildName();
    public abstract ProductBuilder buildPrice();
    public abstract ProductBuilder buildCategory();
    public abstract ProductBuilder buildCalorific();
    public abstract ProductBuilder buildSize();
    public abstract ProductBuilder buildSeasonality();
}
