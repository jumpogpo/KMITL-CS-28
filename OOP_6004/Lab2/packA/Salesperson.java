package packA;

import java.lang.Math;

public class Salesperson extends Programmer {
    private int target;

    public Salesperson(String n, int exp, int sal, int assignedTarget) {
        super(n, exp, sal);
        target = assignedTarget;
    }

    public Salesperson(String n, int exp) {
        super(n);
        super.setExperience(exp);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public void setSalary() {
        super.salary += (salary * 10) / 100;
    }

    @Override
    public void setSalary(int incresedAmount) {
        super.salary += incresedAmount;
    }

    public String makeQuotation() {
        int randomNumber = (int) (Math.random() * 1000);
        return "Dear value customer, " + randomNumber + " is my best offer.";
    }

    @Override
    public String toString() {
        return String.format("Salesperson [target=%d Programmer [name=%s, salary=%d, experience=%d] ]", target, super.getName(), super.salary, super.getExeperience());
    }
}