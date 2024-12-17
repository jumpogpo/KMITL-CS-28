import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Ex2 {
    public static final int MAX = 5;

    // Check if the number is a valid integer
    public static boolean isValidType(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    // Check if the number is in the range [0, 10]
    public static boolean isValidRange(int num) {
        if (num < 0 || num > 10) {
            return false;
        }

        return true;
    }

    // Process the input
    public static List<Integer> processInput() {
        Scanner inp = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter 5 valid integers in the range [0, 10]");

        while (nums.size() < MAX) {
            String s = inp.nextLine();

            if (!isValidType(s)) {
                System.out.println("Invalid! Try again!");
                continue;
            }

            int num = Integer.parseInt(s);

            if (!isValidRange(num)) {
                System.out.println("Invalid range! Try again!");
                continue;
            }

            nums.add(num);
        }

        inp.close();
        return nums;
    }

    // Sort the data
    public static void sortData(List<Integer> nums) {
        Collections.sort(nums);
    }

    // Display the data
    public static void displayData(List<Integer> nums) {
        for (int num : nums)
            System.out.print(num + " ");
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("Welcome to the Application!");
        List<Integer> nums = processInput();
        sortData(nums);
        displayData(nums);
    }
}