package com.leetcode.brush;

import java.util.HashMap;
import java.util.Map;

public class ArrayMajorityElement {

    public int majorityElement(int[] nums) {
        int m = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num) == null ? 0 : map.get(num);
            integer = integer + 1;
            map.put(num, integer);
            if (integer > m) {
                return num;
            }
        }
        return -1;
    }

    public int majorityElementOne(int[] nums) {
        // 投票算法
        int temp = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                temp = nums[i];
                count = 1;
            }
        }

        // 验证是否满足要求
        int t = nums.length / 2 + 1;
        count = 0;
        for (int num : nums) {
            if (num == temp) count++;
            if (count == t) return temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayMajorityElement arrayMajorityElement = new ArrayMajorityElement();
        int[] a = {2,2,1,1,1,2,2};
        System.out.println(arrayMajorityElement.majorityElementOne(a));
    }
}
