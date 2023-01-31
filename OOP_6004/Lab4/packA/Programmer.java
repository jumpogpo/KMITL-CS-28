package packA;

import java.util.ArrayList;

public class Programmer extends Employee {
    private ArrayList<String> skills;

    public Programmer(String name, int exp, int sal) {
        super();
        super.name = name;
        super.experience = exp;
        super.salary = sal;
    }

    @Override
    public void sayHi() {
        System.out.println("Say hi from Programmer");
    }

    public String coding() {
        return "Programmer Coding";
    }
}