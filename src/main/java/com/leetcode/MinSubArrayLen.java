/**
 * @(#)MinSubArrayLen.java, 2020/6/16.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.leetcode;

/**
 *
 */
public class MinSubArrayLen {
    //给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回
// 0。
//
// 示例:
//
// 输入: s = 7, nums = [2,3,1,2,4,3]
//输出: 2
//解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
//
//
// 进阶:
//
// 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
// Related Topics 数组 双指针 二分查找
// leetcode submit region begin(Prohibit modification and deletion)
    public static void main(String[] args) {
        MinSubArrayLen m = new MinSubArrayLen();
        int s1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int res1 = m.minSubArrayLen(s1, nums1);
        System.out.println(res1);

        int s2 = 1;
        int[] nums2 = {1};
        int res2 = m.minSubArrayLen(s2, nums2);
        System.out.println(res2);

        int s3 = 3;
        int[] nums3 = {1, 1};
        int res3 = m.minSubArrayLen(s3, nums3);
        System.out.println(res3);
    }


    // 暴力法
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < n; j++) {
                cur += nums[j];
                if (cur >= s) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res;
    }

    // 双指针法
    public int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int cur = nums[left];
        while (left < len) {
            if (cur >= s) {
                cur = cur - nums[left];
                min = Math.min(min, right - left + 1);
                left = left + 1;
            } else {
                right = right + 1;
                if (right >= len) {
                    break;
                }
                cur = cur + nums[right];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
