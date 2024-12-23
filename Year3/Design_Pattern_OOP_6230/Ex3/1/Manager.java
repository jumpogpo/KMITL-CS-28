public class Manager implements ISalary, IHire, ITrain, IAddBonus {
    private Salary salary;
    private Hire hire;
    private Train train;
    private AddBonus addBonus;

    public Manager() {
        this.salary = new Salary();
        this.hire = new Hire();
        this.train = new Train();
        this.addBonus = new AddBonus();
    }

    public void salary() {
        salary.salary();
    }

    public void hire() {
        hire.hire();
    }

    public void train() {
        train.train();
    }

    public void addBonus() {
        addBonus.addBonus();
    }
}
