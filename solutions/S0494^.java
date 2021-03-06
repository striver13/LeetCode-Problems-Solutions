package solutions;

/**
 * 494. 目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

 

示例：

输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
 */
public class S0494 {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for(int i = 1; i < nums.length; i++) {
            for(int sum = -1000; sum<=1000; sum++) {
                if(dp[i-1][sum+1000] > 0) {
                    dp[i][sum+nums[i]+1000] += dp[i-1][sum+1000];
                    dp[i][sum-nums[i]+1000] += dp[i-1][sum+1000];
                }
            }
        }
        return S > 1000? 0: dp[nums.length-1][S+1000];
    }
}