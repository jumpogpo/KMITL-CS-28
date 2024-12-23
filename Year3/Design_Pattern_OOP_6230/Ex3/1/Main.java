public class Main  {
    public static void main(String[] args) {
        System.out.println("***** [CEO] *****");
        CEO ceo = new CEO();
        ceo.salary();
        ceo.addBonus();
        ceo.makeDecisions();
        ceo.addStocks();

        System.out.println("***** [Manager] *****");
        Manager manager = new Manager();
        manager.salary();
        manager.hire();
        manager.train();
        manager.addBonus();

        System.out.println("***** [Employee] *****");
        Employee employee = new Employee();
        employee.salary();
    }
}
