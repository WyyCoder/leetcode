package com.leetcode.brush;

import java.util.Arrays;

/**
 * @author peng.wang
 * @program Array_RunningSum
 * @Description: https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * @date 2020/8/21 4:09 下午
 */
public class ArrayRunningSum {

    /**
     * 创建一个和给定数组同样大小的数组，设定一个变量，将每次循环的元素和变量累加，并且一次放入新创建对数组中即可。
     *
     * time:0ms; memory:39.8MB
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
        int[] i = new int[nums.length];
        int c = 0;
        for (int a = 0; a < nums.length; a++) {
            int num = nums[a];
            c = c + num;
            i[a] = c;
        }
        return i;
    }

    public static void main(String[] args) {
        ArrayRunningSum arrayRunningSum =  new ArrayRunningSum();
        int[] b = {1,1,1,1,1};
        System.out.println(Arrays.toString(arrayRunningSum.runningSum(b)));

    }
}
