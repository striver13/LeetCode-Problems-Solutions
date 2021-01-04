package solutions;

/**
 * 303. 区域和检索 - 数组不可变
给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。

实现 NumArray 类：

NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 

示例：

输入：
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
输出：
[null, 1, -1, -3]

解释：
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
 */
public class S0303 {
    int[] arr;
    public NumArray(int[] nums) {
        if(nums.length==0) {
            arr = new int[1];
            arr[0] = 0;
            return;
        }
        arr = new int[nums.length+1];
        arr[0] = 0;
        for(int i = 1 ;i <=nums.length; i++){
            arr[i] = arr[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return arr[j+1]-arr[i];
    }
}