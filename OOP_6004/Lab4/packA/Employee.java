package packA;

public abstract class Employee {
    protected String name;
    protected int experience, salary;

    public Employee(String n, int exp, int sal) {
        name = n;
        experience = exp;
        salary = sal;        
    }

    public Employee() {}

    public void sayHi() {
        System.out.println("Say hi from Employee");
    }
}
