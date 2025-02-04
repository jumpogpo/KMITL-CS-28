public class App {
    public static void main(String[] args) {
        Beverage plainBeverage = new PlainBeverage();
        System.out.println("You order " + plainBeverage.getDescription());
        System.out.println("The cost is " + plainBeverage.getCost());

        Beverage beverageWithMilkAndSugar = new SugarDecorator(new SugarDecorator(new MilkDecorator(new PlainBeverage())));
        System.out.println("You order " + beverageWithMilkAndSugar.getDescription());
        System.out.println("The cost is " + beverageWithMilkAndSugar.getCost());
    }
}
