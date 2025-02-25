public class App {
    public static void main(String[] args) {
        Employee ceo = new Employee("Settha", "CEO", 500000);

        Employee headSales = new Employee("Kamphaka", "Head Sales", 300000);
        Employee sales1 = new Employee("Wiroj", "Sales", 150000);
        Employee sales2 = new Employee("Weeranan", "Sales", 100000);

        Employee headMarketing = new Employee("UngInk", "Head Marketing", 300000);
        Employee marketing1 = new Employee("Oak", "Marketing", 200000);
        Employee marketing2 = new Employee("Aem", "Marketing", 250000);

        ceo.addSubordinate(headSales);
        ceo.addSubordinate(headMarketing);

        headSales.addSubordinate(sales1);
        headSales.addSubordinate(sales2);

        headMarketing.addSubordinate(marketing1);
        headMarketing.addSubordinate(marketing2);

        printAllEmployee(ceo, 0);
    }

    public static void printAllEmployee(Employee employee, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(employee);

        for (Employee sub : employee.getSubordinates()) {
            printAllEmployee(sub, level + 1);
        }
    }
}
