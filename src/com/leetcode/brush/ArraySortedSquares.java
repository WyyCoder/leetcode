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
     * time:3ms; memory:40.6 MB
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

    /**
     * time:1ms; memory:40.7MB
     *
     * 参考官方的一个题解，比较秒，debug学习了下。
     *
     * 思路：两指针分别在数组前后遍历给定数组。
     * 细节：每一次循环，一前一后的两个元素进行相加，如果结果是负数，则对前边的指针元素进行平方计算，否则对后面指针元素进行计算。
     * 要对新数组从后向前赋值，因为给定的数组是从大到小排序好的。所以遍历的时候，要后往前依次赋值。
     *
     * 对我来说，没仔细审题，因为肯定的数组是排序好的，无论是否有负数。这点很重要。
     *
     * @param A
     * @return
     */
    public int[] sortedSquaresSecond(int[] A) {
        int[] ans = new int[A.length];
        int i = 0, j = A.length-1, k = A.length-1;
        while(i <= j){
            if(A[i] + A[j] < 0){
                ans[k--] = A[i]*A[i];
                i++;
            }else{
                ans[k--] = A[j]*A[j];
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArraySortedSquares arraySortedSquares = new ArraySortedSquares();
        int[] b = {100,3,10};
        int[] ints = arraySortedSquares.sortedSquaresSecond(b);
        for (int d : ints) {
            System.out.println(d);
        }
    }
}
