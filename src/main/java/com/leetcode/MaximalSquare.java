package com.leetcode;

/**
 * 【工程】: tarscode 包名: com.leetcode 类名: MaximalSquare
 * 【作者】: liuyang
 * 【时间】: 2020/6/22 14:08
 * 【题目】:
 * 【内容】:
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//
// 示例:
//
// 输入:
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4
// Related Topics 动态规划


public class MaximalSquare {

    public static void main(String[] args) {
        MaximalSquare t = new MaximalSquare();
        System.out.println();
    }

    /**
     * sum(i,j) = Math.min(sum(i+1,j),sum(i,j+1),sum(i+1,j+1))+1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];
        int max = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    sum[i][j] = 0;
                    continue;
                }
                if (j == n - 1 || i == m - 1) {
                    sum[i][j] = 1;
                } else {
                    sum[i][j] = Math.min(Math.min(sum[i][j + 1], sum[i + 1][j]), sum[i + 1][j + 1]) + 1;
                }

                max = Math.max(sum[i][j], max);
            }
        }
        return max * max;
    }
}