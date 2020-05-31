/**
 * @(#)LengthOfLongestSubstring.java, 2020/5/26.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.leetcode;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author 刘洋 (liuyang3@corp.netease.com)
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 求以当前元素结尾的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        char[] arr = s.toCharArray();
        int max = 1;
        int left = 1;
        int cur = 1;
        for (int i = 1; i < len; i++) {
            boolean done = true;
            for (int j = 0; j < left; j++) {
                cur = j + 1;
                if (arr[i - j - 1] == arr[i]) {
                    done = false;
                    break;
                }
            }

            if (done) {
                cur = left + 1;
            }
            max = Math.max(cur, max);
            left = cur;
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        char[] arr = s.toCharArray();
        int max = 1;
        int left = 1;
        int cur = 1;

        return 0;
    }

}
