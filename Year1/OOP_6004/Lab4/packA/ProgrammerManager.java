package packA;

public class ProgrammerManager extends Programmer implements ManagerRoles {

    public ProgrammerManager(String name, int exp, int sal) {
        super(name, exp, sal);
    }

    public void sayHi() {
        System.out.println("Coding in [solidity, typescript]");
    }

    public String coding() {
        return "ProgrammerManager Coding";
    }

    public int evaluate(Programmer p) {
        p.salary += (p.salary * 15) / 100;;
        return p.salary;
    }

    public String toString() {
        return String.format("ManagerProgrammer [name=%s, experience=%d salary=%d]", name, experience, salary);
    }
}