//make this class a subclass of customer
public class MountainCustomer extends Customer {
    @Override
    public String createMail() {
        return "Mountain Customer Mail";
    }

    @Override
    public String createBrochure() {
        return "Mountain Customer Brochure";
    }
}
