import java.util.Scanner;

public class Lab5_65368 {
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		if (n == 0 || W == 0) {
			return 0;
		}
		
		if (wt[n - 1] > W) {
			return knapSack(W, wt, val, n - 1);
		} else {
			return max(val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1), knapSack(W, wt, val, n - 1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] knapSackWeight = {2, 10, 5, 5};
		int[] knapSackValue = {20, 50, 30, 10};
		int currentWeight = 0;
		int currentValue = 0;
		String symbol = "";

		System.out.print("Input the max weight: ");
		int maxWeight = sc.nextInt();

		for (int a = 0; a < knapSackWeight.length / 2; a++) {
			for (int b = 0; b < knapSackWeight.length / 2; b++) {
				for (int c = 0; c < knapSackWeight.length / 2; c++) {
					for (int d = 0; d < knapSackWeight.length / 2; d++) {
						currentWeight = 0;
						currentValue = 0;

						if (a == 1) {
							currentValue += knapSackValue[0];
							currentWeight += knapSackWeight[0];
						}

						if (b == 1) {
							currentValue += knapSackValue[1];
							currentWeight += knapSackWeight[1];
						}

						if (c == 1) {
							currentValue += knapSackValue[2];
							currentWeight += knapSackWeight[2];
						}

						if (d == 1) {
							currentValue += knapSackValue[3];
							currentWeight += knapSackWeight[3];
						}

						if (currentWeight > maxWeight) {
							symbol = "X";
						} else if (knapSack(maxWeight, knapSackWeight, knapSackValue, knapSackWeight.length) == currentValue) {
							symbol = "*";
						} else {
							symbol = "";
						}

						System.out.printf("%d%d%d%d | Weight = %d | Value = %d %s%n", a, b, c, d, currentWeight, currentValue, symbol);
					}
				}
			}	
		}

		sc.close();
		
	}
}