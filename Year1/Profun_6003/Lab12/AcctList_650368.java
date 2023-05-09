import java.util.ArrayList;

public class AcctList_650368 {
    public static void main(String[] args) {
        AcctList clients = new AcctList();
        String startWith = "c";
        System.out.println("List of account name start with " + startWith.toUpperCase());
        System.out.println(clients.filterName(startWith.toUpperCase()));
        int bound = 1400;
        System.out.println("List of account balance less than " + bound);
        System.out.println(clients.balanceLessThan(bound));
    }
    
}

class AcctList {
    ArrayList<Account> acctList;

    AcctList() {
        acctList = new ArrayList<>();
        acctList.add(new Account(1, "Cactus", 1000));
        acctList.add(new Account(2, "Celsia", 500));
        acctList.add(new Account(3, "Clove pink", 1500));
        acctList.add(new Account(4, "Crown Imperial", 900));
        acctList.add(new Account(5, "Daffodil", 1200));
        acctList.add(new Account(6, "Daisy", 1700));
        acctList.add(new Account(7, "Dandelion", 500));
        acctList.add(new Account(8, "Dittany", 600));
    }

    ArrayList<Account> filterName(String c) {
        ArrayList<Account> result = new ArrayList<>();

        for (Account acc : acctList) {
            if (acc.getName().startsWith(c)) {
                result.add(acc);
            }
        }

        return result;
    }

    ArrayList<Account> balanceLessThan(int b) {
        ArrayList<Account> result = new ArrayList<>();

        for (Account acc : acctList) {
            if (acc.getBalance() < b) {
                result.add(acc);
            }
        }

        return result;
    }
}