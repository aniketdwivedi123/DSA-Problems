class Solution {

    public int minimizeTheDifference(int[][] mat, int target) {

        // dp[s] = kya sum 's' banana possible hai?
        boolean[] dp = new boolean[4901];

        // Shuruaat mein sum 0 possible hai
        dp[0] = true;

        // Har row ko ek-ek karke process karenge
        for (int row = 0; row < mat.length; row++) {

            boolean[] next = new boolean[4901];

            // Pichli rows se banne wale saare sums check karo
            for (int sum = 0; sum <= 4900; sum++) {

                if (!dp[sum]) {
                    continue;
                }

                // Current row ke har number ko choose karo
                for (int num : mat[row]) {

                    int newSum = sum + num;

                    // Naya sum possible hai
                    if (newSum <= 4900) {
                        next[newSum] = true;
                    }
                }
            }

            // Current row process hone ke baad
            // next ko dp bana do
            dp = next;
        }

        // Target ke sabse paas wala sum find karo
        int answer = Integer.MAX_VALUE;

        for (int sum = 0; sum <= 4900; sum++) {

            if (dp[sum]) {
                answer = Math.min(answer, Math.abs(target - sum));
            }
        }

        return answer;
    }
}