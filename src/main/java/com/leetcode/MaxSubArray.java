package com.leetcode;

/**
 * 【工程】: tarscode 包名: com.leetcode 类名: MaxSubArray
 * 【作者】: liuyang
 * 【时间】: 2020/6/21 21:47
 * 【题目】:
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】: 从右向左依次取出以当前位置为开头子数组的最大值
 */

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划


public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray t = new MaxSubArray();
        System.out.println();
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int right = nums[n -1];
        int max = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int cur = Math.max(nums[i], nums[i] + right);
            right = cur;
            max = Math.max(max, cur);
        }
        return max;
    }
}