package decorator;

public class Milk implements Food {
    private String name;
    private int weight;

    @Override
    public String getNameProduct() {
        return this.name;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}
