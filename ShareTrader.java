import java.util.*;

public class ShareTrader {

    // Static variable to store maximum profit
    private static int maxProfit = 0;

    // Static method to find the maximum profit with at most 2 transactions
    public static void findMaxProfit(int[] prices) {
        int n = prices.length;
        
        // If there are less than 2 prices, no transactions can be made
        if (n < 2) {
            System.out.println("No profit can be made.");
            return;
        }

        // Arrays to store maximum profit up to each day for first and second transactions
        int[] profitFirstTransaction = new int[n];
        int[] profitSecondTransaction = new int[n];

        // Step 1: Calculate maximum profit for the first transaction from day 0 to day i
        int minPriceFirst = prices[0]; // Buy at the lowest price seen so far
        for (int i = 1; i < n; i++) {
            minPriceFirst = Math.min(minPriceFirst, prices[i]);
            profitFirstTransaction[i] = Math.max(profitFirstTransaction[i - 1], prices[i] - minPriceFirst);
        }

        // Step 2: Calculate maximum profit for the second transaction from day i to the last day
        int maxPriceSecond = prices[n - 1]; // Sell at the highest price seen from right to left
        for (int i = n - 2; i >= 0; i--) {
            maxPriceSecond = Math.max(maxPriceSecond, prices[i]);
            profitSecondTransaction[i] = Math.max(profitSecondTransaction[i + 1], maxPriceSecond - prices[i]);
        }

        // Step 3: Combine the results of the two transactions to find the maximum profit
        maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, profitFirstTransaction[i] + profitSecondTransaction[i]);
        }

        // Output the maximum profit
        System.out.println("Maximum profit: " + maxProfit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the size of the array from the user
        System.out.println("Enter the number of stock prices for the day:");
        int n = scanner.nextInt();

        // Accept the stock prices for the day from the user
        int[] prices = new int[n];
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Call the method to calculate the maximum profit
        findMaxProfit(prices);

        scanner.close();
}
}