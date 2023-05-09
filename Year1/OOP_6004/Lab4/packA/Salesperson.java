package packA;

import java.lang.Math;

public class Salesperson extends Employee implements SalesRoles {
    private int target;

    public void sayHi() {
        System.out.println("Say hi from Salesperson");
    }

    public void setSalary() {
        super.salary += (salary * 10) / 100;
    }

    public void setSalary(int incresedAmount) {
        super.salary += incresedAmount;
    }

    public String makeQuotation() {
        int randomNumber = (int) (Math.random() * 1000);
        return "Dear value customer, " + randomNumber + " is my best offer.";
    }
}