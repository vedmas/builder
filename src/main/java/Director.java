public class Director {
    private ProductBuilder productBuilder;

    public void setProductBuilder(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product getProduct() {
        return productBuilder.getProduct();
    }

    public Product foodProductConstructor() {
        return productBuilder.createNewProduct()
                .buildName()
                .buildPrice()
                .buildCategory()
                .buildCalorific()
                .getProduct();
    }

    public Product shoesProductConstructor() {
        return productBuilder.createNewProduct()
                .buildName()
                .buildPrice()
                .buildCategory()
                .buildSize()
                .buildSeasonality()
                .getProduct();
    }
}
