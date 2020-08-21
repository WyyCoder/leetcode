package com.leetcode.brush;


import java.util.HashMap;
import java.util.Map;

/**
 * @author peng.wang
 * @program Solution
 * @Description: two sum 两数之和
 * @url https://leetcode-cn.com/problems/two-sum/
 * @date 2019/3/5 5:12 PM
 */
public class ArrayTwoSumSolution {

    /**
     * 利用两个for循环，数组里的每一个元素去和它之后的元素依次相加，是否等于目标值，等于即返回
     *
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 利用两个for循环，一个for是先把数组中所有的元素放入hash表中，key是值，value是所对应的索引。
     * 放入之后，再开启另一个循环，用目标值和数组中的元素相减，得到的结果去hash表中获取，如果得到即返回对应的value,和当前元素的索引。
     *
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * 一个for循环，一个hash表（key 目标值和数组元素的差值，value 数组元素的索引）。
     * 将元素中的每一个值和目标值相减，得到的放入hash表中，如果某一个元素中，hash表存在，则返回。
     *
     * @param nums
     * @param target
     * @return
     */
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
        ArrayTwoSumSolution arrayTwoSumSolution = new ArrayTwoSumSolution();
        int ta = 6;
        int[] s = {3,3};
        int[] ints = arrayTwoSumSolution.methodThree(s, ta);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }

}
