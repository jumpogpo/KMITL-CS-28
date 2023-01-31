package packA;

public class Accountant extends Employee {
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    @Override
    public void sayHi() {
        System.out.println("Say hi from Accountant");
    }

    public String tellProfit() {
        int randomNumber = (int) (Math.random() * 1000);
        return String.format("%s's profit is %d. My salary is %d", companyName, randomNumber, super.salary);
    }

    public static String tellMyRole() {
        return "I am an accountant at " + companyName;
    }
}