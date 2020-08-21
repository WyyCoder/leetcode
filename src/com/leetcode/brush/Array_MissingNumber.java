package com.leetcode.brush;

/**
 * @author peng.wang
 * @program MissingNumber
 * @Description: https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * @date 2020/8/21 3:24 下午
 */
public class Array_MissingNumber {
    /**
     * time:0s;memory:40.2MB
     *
     * 将这个数组机进行循环，循环的范围是题目给到的数组0～数组+1。当循环到比数组长度大的时候，直接返回当前。
     * 否则判断循环当前数组的值和循环次数不同，则返回循环的次数。
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length + 1; i++) {
            if (i+1 > nums.length) {
                return i;
            }
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Array_MissingNumber arrayMissingNumber = new Array_MissingNumber();
        int[] b = {0};
        System.out.println(arrayMissingNumber.missingNumber(b));
    }
}
