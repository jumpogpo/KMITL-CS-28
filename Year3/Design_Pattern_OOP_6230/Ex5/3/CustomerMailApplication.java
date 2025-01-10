import java.util.Scanner;
public class CustomerMailApplication {
    public static String getCustomerTypeFromUser() {
        String customerType = null;
        Scanner inp = new Scanner(System.in);
        System.out.print("Please choose customer type 1. Regular, 2. Mountain, 3. Delinquent ");
        int type = inp.nextInt();
        switch(type) {
            case 1:
                customerType = "Regular";
                break;
            case 2:
                customerType = "Mountain";
                break;
            case 3:
                customerType = "Delinquent";
                break;
        }
        inp.close();
        return customerType;
    }
    
    public static void main(String[] args) {
        String customerType = getCustomerTypeFromUser();
        
        // Create By Using Factory Method
        Customer customer  = CustomerMailFactory.createCustomer(customerType);
        System.out.println(customer.generateCommunication());        
    }
}
