package com.offer.chapter3;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangcheng on 2018/4/9.
 */
public class Number14 {

    @Test
    public void test()
    {
        int[] array = new int[]{1,2,3,4,5};
        oddBeforeEven(array);
        System.out.println(Arrays.toString(array));
    }

    public void oddBeforeEven(int[] array){
        if(array == null || array.length == 0)
            return;
        int left = 0;
        int right = array.length-1;
        while(left < right){
            while(left < right && (array[right] & 1)==0)
                right--;
            while(left<right && (array[left] & 1) == 1)
                left++;
            if(left < right)
                swap(array,left,right);
        }
    }

    public void swap(int[] array,int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
