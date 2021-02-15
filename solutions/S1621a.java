package solutions;

/**
 * 1621. 大小为 K 的不重叠线段的数目
 * 给你一维空间的 n 个点，其中第 i 个点（编号从 0 到 n-1）位于 x = i 处，请你找到 恰好 k 个不重叠 线段且每个线段至少覆盖两个点的方案数。线段的两个端点必须都是 整数坐标 。这 k 个线段不需要全部覆盖全部
 * n 个点，且它们的端点 可以 重合。
 *
 * 请你返回 k 个不重叠线段的方案数。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4, k = 2
 * 输出：5
 * 解释：
 * 如图所示，两个线段分别用红色和蓝色标出。
 * 上图展示了 5 种不同的方案 {(0,2),(2,3)}，{(0,1),(1,3)}，{(0,1),(2,3)}，{(1,2),(2,3)}，{(0,1),(1,2)} 。
 *
 * dp[i][j][k] 表示取到i分了j组，k=0表示j没有碰到，k=1表示取到j，j碰到了
 * 因此dp[i][j][0] = dp[i-1][j][0] + dp[i-1][j][1] 由于0是没取到的意思，所以分组j不变 就是(0,1),(2,3)这种情况
 * dp[i][j][1] = dp[i-1][j][1];  j==0
 *              = dp[i-1][j][1] + dp[i-1][j-1][0] +dp[i-1][j-1][1] 由于1表示取到了，所以要加上j-1的可能 也就是(0,1),(1,3)这种情况
 */
public class S1621a {
    public int numberOfSets(int n, int k) {
        // dp[][][0]表示右端点没碰到，也就是无法延伸最后一个线段
        // dp[][][1]表示碰到了，可以延伸
        long[][][] dp = new long[n][k+1][2];
        dp[0][0][0] = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= k; j++){
                dp[i][j][0] = (dp[i-1][j][0] + dp[i-1][j][1])%1000000007;
                dp[i][j][1] = dp[i-1][j][1];
                if(j>0) {
                    //  这个是最右边i当作是一个单独的线段
                    dp[i][j][1] = (dp[i][j][1] + dp[i-1][j-1][0])%1000000007;
                    dp[i][j][1] = (dp[i][j][1]+dp[i-1][j-1][1])%1000000007;
                }
            }
        }
        return (int)(dp[n-1][k][0]+dp[n-1][k][1])%1000000007;
    }
}
