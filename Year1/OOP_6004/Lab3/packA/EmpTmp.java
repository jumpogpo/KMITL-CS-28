package packA;

public class EmpTmp {
    protected String name;
    protected int salary;
    protected int experience;

    public EmpTmp(String n, int exp, int sal) {
        name = n;
        experience = exp;
        salary = sal;
    }

    public EmpTmp(String n) {
        name = n;
    }

    public EmpTmp() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(int newSalaray) {
        salary = newSalaray;
    }

    public int getSalary() {
        return salary;
    }

    public void setExperience(int exp) {
        experience = exp;
    }

    public int getExeperience() {
        return experience;
    }

    public String toString() {
        return "Programmer [name=" + name + ", salary=" + salary + ", experience=" + experience + "]";
    }

    public void sayHi() {
        System.out.println("hi from " + name);
    }
}