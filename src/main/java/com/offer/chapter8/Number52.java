package com.offer.chapter8;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangcheng on 2018/6/1.
 */
public class Number52 {

    @Test
    public void test(){
        int[] arrayA = {3,2,4};
        int[] arrayB = getMutiplyArray(arrayA);
        System.out.println(Arrays.toString(arrayB));
    }

    /**
     * 将数组B的合成分为两部分第一部分是①：A[0]*A[1]*A[2]...*A[i-1]第二部分是②：A[i+1]*A[i+2]*A[i+3]...*A[n-1]
     * 第一步得到①的值，第二步得到②的值。
     * @param arrayA
     * @return
     */
    public int[] getMutiplyArray(int[] arrayA){
        int[] arrayB = new int[arrayA.length];
        arrayB[0] = 1;
        for (int i = 1; i < arrayA.length; i++)
            arrayB[i] = arrayB[i-1] * arrayA[i-1];
        int temp = 1;
        for (int i = arrayA.length-2; i >=0 ; i--){
            temp *= arrayA[i+1];
            arrayB[i] *= temp;
        }
        return arrayB;
    }
}
