import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoinCombinations {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of denominations (N): ");
        int n = scanner.nextInt();

        
        int[] coins = new int[n];
        System.out.print("Enter the denominations: ");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        
        System.out.print("Enter the target sum: ");
        int sum = scanner.nextInt();

        
        int result = findWays(coins, sum);
        System.out.println("Number of ways to make the sum: " + result);

        scanner.close();
    }

    public static int findWays(int[] coins, int sum) throws InterruptedException {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        // Number of threads
        int threads = Math.min(coins.length, Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        int step = coins.length / threads;
        for (int i = 0; i < threads; i++) {
            int start = i * step;
            int end = (i == threads - 1) ? coins.length : (i + 1) * step;
            executor.submit(new CoinTask(dp, coins, start, end, sum));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(10);
        }

        return dp[sum];
    }

    static class CoinTask implements Runnable {
        private final int[] dp;
        private final int[] coins;
        private final int start;
        private final int end;
        private final int sum;

        public CoinTask(int[] dp, int[] coins, int start, int end, int sum) {
            this.dp = dp;
            this.coins = coins;
            this.start = start;
            this.end = end;
            this.sum = sum;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                for (int j = coins[i]; j <= sum; j++) {
                    synchronized (dp) {
                        dp[j] += dp[j - coins[i]];
                    }
                }
            }
        }
    }
}
