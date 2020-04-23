
public class Product {
    private String name = null;
    private int price = 0;
    private String category = null;
    private int calorific = 0;
    private int size = 0;
    private String seasonality = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCalorific() {
        return calorific;
    }

    public void setCalorific(int calorific) {
        this.calorific = calorific;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSeasonality() {
        return seasonality;
    }

    public void setSeasonality(String seasonality) {
        this.seasonality = seasonality;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", calorific=" + calorific +
                ", size=" + size +
                ", seasonality='" + seasonality + '\'' +
                '}';
    }
}
