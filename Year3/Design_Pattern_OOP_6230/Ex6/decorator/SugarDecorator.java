public class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        return super.getCost() + 1; // น้ำตาลเพิ่ม 1 บาท
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "sugar ";
    }
}
