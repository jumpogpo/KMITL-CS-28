public class Account_650368 {
    public static void main(String[] args) {
        Account per1 = new Account(1,"Person1" , 1000);
        Account per2 = new Account(2,"Person2" , 500);
        System.out.println(per1.credit(1000));
        System.out.println(per2.debit(1000));
        System.out.println(per1.transferTo(per2, 500));
        System.out.println(per1.toString());
        System.out.println(per2.toString());
    }
}

class Account {
    int id;
    String name;
    int balance = 0;

    Account(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    int getID() {
        return this.id;
    }
    String getName() {
        return this.name;
    }
    int getBalance() {
        return this.balance;
    }
    int credit(int amount) {
        this.balance += amount;
        return balance;
    }
    int debit(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        }
        return this.balance;
    }
    int transferTo(Account acc, int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            acc.balance += amount;
        }
        return this.balance;
    }
    public String toString() {
        return String.format("Account %s(%d) balance is %d", this.name, this.id, this.balance);
    }
}