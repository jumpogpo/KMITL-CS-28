public class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        return super.getCost() + 3; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "milk ";
    }
}
