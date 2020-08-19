package com.leetcode.brush;


import java.util.HashMap;
import java.util.Map;

/**
 * @author peng.wang
 * @program Solution
 * @Description: two sum
 * @url https://leetcode-cn.com/problems/two-sum/
 * @date 2019/3/5 5:12 PM
 */
public class TwoSumSolution {

    public int[] methodOne(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] methodTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            Integer integer = map.get(i1);
            if (integer != null && integer != i) {
                return new int[]{i, integer};
            }
        }
        return null;
    }

    public int[] methodThree(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int i1 = target - num;
            Integer integer = map.get(num);
            if (map.containsKey(num) && integer != i) {
                return new int[]{i, integer};
            }
            map.put(i1, i);
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int ta = 6;
        int[] s = {3,3};
        int[] ints = twoSumSolution.methodThree(s, ta);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

}
