package com.offer.bishi.cvte;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhangcheng on 2018/7/20.
 */
public class Number1 {

    @Test
    public void test(){
        int[] A = {99,92,87,80};
        int[] B = {98,90,82};
        System.out.println(Arrays.toString(merge(A,B)));
    }

    public static  int[] merge(int[] A,int[] B)
    {
        if(A == null || A.length == 0)
            return null;
        if(B == null || B.length == 0)
            return null;
        int[] C = new int[A.length+ B.length];
        int i = 0,j = 0;
        int index = 0;
        while (i < A.length && j < B.length)
        {
            if(A[i] >= B[j])
            {
                C[index++] = A[i++];
            }else
                C[index++] = B[j++];
        }
        while(i<A.length)
            C[index++] = A[i++];
        while (j<B.length)
            C[index++] = B[j++];
        return C;
    }
}
