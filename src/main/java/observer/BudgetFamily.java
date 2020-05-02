package observer;

import java.util.ArrayList;
import java.util.List;

public class BudgetFamily implements Observer {

    private long budget;

    private List<Subscriber> ubl = new ArrayList<>();


    public List<Subscriber> getUbl() {
        return ubl;
    }

    public long getBudget() {
        return budget;
    }

    @Override
    public void subscribe(Subscriber ub) {
        ubl.add(ub);
    }

    @Override
    public void unsubscribe(Subscriber ub) {
        ubl.remove(ub);
    }

    @Override
    public void notifySubscribers(List<Subscriber> ub) {
        for (Subscriber subscriber : ub) {
            subscriber.updateBudgetFamily(this);
        }
    }

    public void setBudget(long budget) {
        this.budget = budget;
        notifySubscribers(ubl);
    }
}
