package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 【工程】: tarscode 包名: com.leetcode 类名: LongestConsecutive
 * 【作者】: liuyang
 * 【时间】: 2020/6/22 18:46
 * 【题目】:
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        LongestConsecutive t = new LongestConsecutive();
        int[] nums = {100,5,10, 4, 200, 1, 3, 2};
        System.out.println(t.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) {
            return max;
        }
        int n = nums.length;
        Set<Integer> set = new HashSet<Integer>(n);

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int cur = 1;
            int i = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + i)) {
                    cur++;
                    i++;
                }
            }
            max = Math.max(cur, max);
        }

        return max;
    }
}