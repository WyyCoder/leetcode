package com.leetcode.brush;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author pengpengjia
 * @Description: https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @date 2020/9/25
 */
public class ArraySortedSquares {
    /**
     * 这种方法比较简单，因为是用的现成的排序方法，算好每个数的平方生成新的数组排序。
     *
     * time:0ms; memory:39.8MB
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int[] a = new int[A.length];
        for (int c = 0; c < a.length; c++) {
            int i = A[c];
            int s = i * i;
            a[c] = s;
        }
        Arrays.sort(a);
        return a;
    }

    public static void main(String[] args) {
        ArraySortedSquares arraySortedSquares = new ArraySortedSquares();
        int[] b = {-4,-1,0,3,10};
        int[] ints = arraySortedSquares.sortedSquares(b);
        for (int d : ints) {
            System.out.println(d);
        }
    }
}
