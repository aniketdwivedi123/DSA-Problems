class Solution {

    static int solve(int amount, int[] coins, int index, int[][] dp) {

        if (amount == 0) {
            return 1;
        }

        if (amount < 0 || index >= coins.length) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Include current coin
        int includeKaAns =
                solve(amount - coins[index], coins, index, dp);

        // Exclude current coin
        int excludeKaAns =
                solve(amount, coins, index + 1, dp);

        dp[index][amount] = includeKaAns + excludeKaAns;

        return dp[index][amount];
    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return solve(amount, coins, 0, dp);
    }
}