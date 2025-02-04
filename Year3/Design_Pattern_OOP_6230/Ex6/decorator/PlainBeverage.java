public class PlainBeverage implements Beverage {
    @Override
    public int getCost() {
        return 5; // ราคาเครื่องดื่มพื้นฐาน
    }

    @Override
    public String getDescription() {
        return "beverage ";
    }
}
