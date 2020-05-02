package observer;

public class User implements Subscriber {
    private String name, role;
    long budgetFamily;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getBudgetFamily() {
        return budgetFamily;
    }

    public void setBudgetFamily(long budgetFamily) {
        this.budgetFamily = budgetFamily;
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public User() {
    }

    @Override
    public void updateBudgetFamily(BudgetFamily bf) {
        setBudgetFamily(bf.getBudget());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", budgetFamily=" + budgetFamily +
                '}';
    }
}
