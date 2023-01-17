package packA;

public class Accountant extends Programmer {
    private static String companyName = "berk barn jamkad";
    private int experience;
    private String specialty;

    public Accountant(String name, int superExp, int experience, int sal, String talent) {
        super(name, superExp, sal);
        this.experience = experience;
        specialty = talent;
    }

    public void setSpecialty(String newSpecialty) {
        specialty = newSpecialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setAccountExperience() {

    }

    public int getAccountExperience() {
        return experience;
    }

    public String tellProfit() {
        int randomNumber = (int) (Math.random() * 1000);
        return String.format("%s's profit is %d. My salary is %d", companyName, randomNumber, super.salary);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d can %s", super.getName(), super.getExeperience(), experience, specialty);
    }

    @Override
    public void sayHi() {
        int randomNumber = (int) (Math.random() * 1000);
        System.out.printf("%s's profit is %d. My salary is %d%n", companyName, randomNumber, super.salary);
    }

    public static String tellMyRole() {
        return "I am an accountant at " + companyName;
    }
}