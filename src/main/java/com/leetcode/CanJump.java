/**
 * @(#)CanJump.java, 2020/5/24.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.leetcode;

/**
 * 题目:55. 跳跃游戏
 * 思路:最后一个位置可以到达,说明每一个位置都可以到达
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 *
 * @author 刘洋
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums1));
        System.out.println(canJump(nums2));
    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int len = nums.length;
        // 存储可以到达的位置
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 0; i < len; i++) {
            // 判断当前位置是否可以到达
            if (res[i] == 0) {
                return false;
            }
            // 到达最后最后位置
            if (i == len - 1) {
                return true;
            }
            // 获取当前可以走的步数
            int cur = nums[i];
            // 标记可以到达的位置
            for (int j = 1; j <= cur; j++) {
                if ((i + j) >= (len - 1)) {
                    return true;
                }
                res[i + j] = 1;
            }
        }
        return false;
    }

    public static boolean canJump2(int[] nums) {
        int len = nums.length;
        int max = 0;// 记录当前最多可以往右走几步
        for (int i = 0; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
                if (max >= len - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
