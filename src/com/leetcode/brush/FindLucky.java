package com.leetcode.brush;

import java.util.HashMap;
import java.util.Map;

/**
 * @author peng.wang
 * @program FindLucky
 * @Description: https://leetcode-cn.com/problems/find-lucky-integer-in-an-array/
 * @date 2020/8/20 4:43 下午
 */
public class FindLucky {

    /**
     * 不是最优解
     *
     * time : 8 ms  memory :39.3 MB
     *
     * 两次for循环，先将数组中的元素放入map中（key 元素，value 元素出现的次数），再次对map进行for循环，找去幸运数，且最大的哪一个。
     *
     * @param arr
     * @return
     */
    public int findLuckyOne(int[] arr) {
        int a = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i1 : arr) {
            Integer integer = map.get(i1) == null ? 0 : map.get(i1);
            integer = integer + 1;
            map.put(i1, integer);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            Integer key = integerIntegerEntry.getKey();
            if (value.equals(key) && key > a) {
                a = key;
            }
        }
        return a;
    }

    /**
     * 根据题解提示得到这个解法，先将给的数组元素放入一个数组，使给定的数组元素当新数组的下标。新元素的数组值为每个元素出现的次数。
     * 如果新数组的下标等于其元素的话，就认为他是幸运数，然后将新数组根据下标倒叙循环，得到最大的下标，即返回。
     *
     * notice : 一定看题目给的提示信息
     *
     * time:1s memory:39.5MB
     *
     * @param arr
     * @return
     */
    public int findLuckyTwo(int[] arr) {
        int[] t = new int[500];
        for (int a : arr) {
            t[a]++;
        }
        for (int i = t.length - 1; i > 0; i--) {
            if (i == t[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,19,18,2,9,4,7,11,15,7,14,10,11,9,8,5,4,14,11,4,16,3,13,14,14,15,8,19,3,5,20,15,14,10,16,11,17,20,11,20,15,3,20,5,12,2,15,12,14,16,20,17,15,8,18,9,8,5,12,3,5,15,14,10,2,20,20,3,13,9,1,3,16,18,14,16,13,9,18,13,9,3,5,19};
        FindLucky findLucky = new FindLucky();
        int lucky = findLucky.findLuckyTwo(arr);
        System.out.println(lucky);
    }
}
