package solutions;

import java.util.Map;
import java.util.HashMap;

/**
932. 漂亮数组
对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：

对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。

那么数组 A 是漂亮数组。

 

给定 N，返回任意漂亮数组 A（保证存在一个）。

 

示例 1：

输入：4
输出：[2,1,4,3]
 */
public class S0932 {
    Map<Integer, int[]> memo;
    public int[] beautifulArray(int N) {
        memo = new HashMap<>();
        return helper(N);
    }

    public int[] helper(int N){
        if(memo.containsKey(N)){
            return memo.get(N);
        }

        int[] ans = new int[N];
        if(N==1){
            ans[0]=1;
        } else {
            int t = 0;
            for(int x : helper((N+1)/2)) ans[t++] = 2*x-1;
            for(int x : helper((N)/2)) ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }
}