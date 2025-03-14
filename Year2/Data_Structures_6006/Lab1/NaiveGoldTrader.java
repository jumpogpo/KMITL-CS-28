import java.util.Scanner;

public class NaiveGoldTrader {
    static int readGoldPrices(int goldPrices[]) {
        int count = 0;
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String data = sc.nextLine();
            goldPrices[count] = Integer.parseInt(data);
            count++;
        }

        sc.close();
        return count;
    } 

    static int readGoldPrices(int goldPrices[], int n) {
        for (int i = 0; i < n; i++) {
            goldPrices[i] = (int) Math.round(Math.random() * 20000 + 20000);
        }
        return n;
    }

    public static void main(String args[]) {
        int goldPrices[] = new int[1000000];

        // Solution 1
        int n = readGoldPrices(goldPrices);

        // Solution 2 *To use uncomment 2 line 32 and 33*
        // int n = Integer.parseInt(args[0]);
        // readGoldPrices(goldPrices, n);

        int bestBuyDate = 0;
        int bestSellDate = 0;
        int maxProfit = Integer.MIN_VALUE;
        long count = 0;
        for (int buyDate = 0; buyDate < n - 1; buyDate++) {
            for (int sellDate = buyDate + 1; sellDate < n; sellDate++) {
                count++;
                int profit = goldPrices[sellDate] - goldPrices[buyDate];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    bestBuyDate = buyDate;
                    bestSellDate = sellDate;
                }
            }
        }
        System.out.println("Number of days: " + n);
        System.out.println("Max profit is: " + maxProfit);
        System.out.println("Buy date: " + (bestBuyDate + 1));
        System.out.println("Sell date: " + (bestSellDate + 1));
        System.out.println("count: " + count);
    }
}
