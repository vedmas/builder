package observer;

public class ObserverExample {
    public static void main(String[] args) {
        BudgetFamily bf = new BudgetFamily();
        User user1 = new User("Bob", "Father");
        User user2 = new User("Jain", "Mather");
        bf.subscribe(user1);
        bf.subscribe(user2);
        System.out.println("Добавили в подписку " + bf.getUbl().size() + " пользователя(ей)");
        for (Subscriber subscriber : bf.getUbl()) {
            System.out.println(subscriber);
        }
        bf.setBudget(10000);
        System.out.println("Установили бюджет семьи в размере " + bf.getBudget() + " руб.");
        System.out.println(user1);
        System.out.println(user2);
        bf.setBudget(8500);
        System.out.println("Установили бюджет семьи в размере " + bf.getBudget() + " руб.");
        System.out.println(user1);
        System.out.println(user2);
    }
}
