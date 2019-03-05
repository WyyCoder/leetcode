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

    /**
     * first method
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSumFirst(int[] nums, int target) {
        int[] ints = {};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ints = new int[]{i, j};
                    return ints;
                }
            }
        }
        return ints;
    }

    /**
     * second method
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSumSecond(int[] nums, int target) {
        int[] ints = {};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j) && map.get(j) != i) {
                return new int[]{map.get(j), i};
            }
        }
        return ints;
    }

    /**
     * third method
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] thirdSumSecond(int[] nums, int target) {
        int[] ints = {};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            if (map.containsKey(j)) {
                return new int[]{map.get(j), i};
            }
            map.put(nums[i], i);
        }
        return ints;
    }

    public static void main(String[] args) {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int[] ints = twoSumSolution.twoSumFirst(new int[]{3, 3}, 6);
        if (ints.length > 0) {
            System.out.println("first index：" + ints[0]);
            System.out.println("second index：" + ints[1]);
        } else {
            System.out.println("none ! ! !");
        }
    }

}
