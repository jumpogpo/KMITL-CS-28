public class CEO implements ISalary, IAddBonus, IMakeDecisions, IAddStocks {
    private Salary salary;
    private AddBonus addBonus;
    private MakeDecisions makeDecisions;
    private AddStocks addStocks;

    public CEO() {
        this.salary = new Salary();
        this.addBonus = new AddBonus();
        this.makeDecisions = new MakeDecisions();
        this.addStocks = new AddStocks();
    }

    public void salary() {
        salary.salary();
    }

    public void addBonus() {
        addBonus.addBonus();
    }

    public void makeDecisions() {
        makeDecisions.makeDecisions();
    }

    public void addStocks() {
        addStocks.addStocks();
    }
}
