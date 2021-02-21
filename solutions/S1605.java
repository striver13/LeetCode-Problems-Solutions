package solutions;

/**
 * 1605. 给定行和列的和求可行矩阵
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 *
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
 *
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 *
 *
 *
 * 示例 1：
 *
 * 输入：rowSum = [3,8], colSum = [4,7]
 * 输出：[[3,0],
 *       [1,7]]
 * 解释：
 * 第 0 行：3 + 0 = 3 == rowSum[0]
 * 第 1 行：1 + 7 = 8 == rowSum[1]
 * 第 0 列：3 + 1 = 4 == colSum[0]
 * 第 1 列：0 + 7 = 7 == colSum[1]
 * 行和列的和都满足题目要求，且所有矩阵元素都是非负的。
 * 另一个可行的矩阵为：[[1,2],
 *                   [3,5]]
 */
public class S1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;
        int[][] matrix = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                matrix[i][j] = min;
                rowSum[i] -=min;
                colSum[j] -=min;
            }
        }
        return matrix;
    }
}
