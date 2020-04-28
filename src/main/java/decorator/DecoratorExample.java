package decorator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DecoratorExample {
    public static void main(String[] args) {
        BudgetFood budgetFood = new BudgetFood();
        List<Food> foodList = new LinkedList<>(Arrays.asList(new Milk(), new Bread()));
        budgetFood.setFoodList(foodList);
    }
}
