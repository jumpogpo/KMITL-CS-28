package packA;

public class Programmer extends EmpTmp {
    public Programmer(String n, int exp, int sal) {
        super(n, exp, sal);
    }

    @Override
    public void sayHi() {
        System.out.println("hi from" + super.name);
    }

    @Override
    public String toString() {
        return "Programmer []";
    }

    public String coding() {
        return "Coding";
    }
}