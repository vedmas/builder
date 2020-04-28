package decorator;

import java.util.LinkedList;
import java.util.List;

public class BudgetFood {
    private List<Food> foodList = new LinkedList<>();

    public BudgetFood() {
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
