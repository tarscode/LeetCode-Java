package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 【工程】: tarscode 包名: com.leetcode 类名: TwoSum
 * 【作者】: liuyang
 * 【时间】: 2020/6/22 23:43
 * 【题目】:
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(t.twoSum(nums, target)[0]);
        System.out.println(t.twoSum(nums, target)[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(n);
        Map<Integer, Integer> count = new HashMap<Integer, Integer>(n);
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else {
                count.put(nums[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            int expect = target - nums[i];
            if (expect == nums[i] && count.get(nums[i]) < 2) {
                continue;
            }
            if (map.containsKey(expect)) {
                return new int[]{i, map.get(expect)};
            }
        }
        return null;
    }
}