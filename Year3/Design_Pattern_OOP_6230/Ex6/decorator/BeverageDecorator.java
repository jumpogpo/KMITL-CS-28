public abstract class BeverageDecorator implements Beverage {
    protected Beverage decoratedBeverage;

    public BeverageDecorator(Beverage beverage) {
        this.decoratedBeverage = beverage;
    }

    @Override
    public int getCost() {
        return decoratedBeverage.getCost();
    }

    @Override
    public String getDescription() {
        return decoratedBeverage.getDescription();
    }
}
