package homework23;

public class BankAccount {
    private int money;

    public BankAccount(int money) {
        this.money = money;
    }

    public synchronized void pay(int amount, String name) {
        if (money >= amount) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            money -= amount;
            System.out.println(name + " gets: " + amount + " balance: " + money);

        } else {
            System.out.println("Sorry " + name + ", not enough money: " + money);
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "money=" + money +
                '}';
    }
}
