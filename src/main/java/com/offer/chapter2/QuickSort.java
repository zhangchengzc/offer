package com.offer.chapter2;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangcheng on 2018/4/7.
 */
public class QuickSort {

    @Test
    public void test(){
        int[] num = {4,5,7,8,1,2,2,3,6};
        quickSort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }


    public void quickSort(int[] array,int begin,int end){
        if(begin < end) {
            int index = partition(array, begin, end);
            quickSort(array, begin, index - 1);
            quickSort(array, index + 1, end);
        }
    }

    public int partition(int[] array,int left,int right){
        int pivot = array[left];
        while(left < right)
        {
            while(array[right] >= pivot && left<right)
                right--;
            array[left] = array[right];
            while(array[left] <= pivot && left<right)
                left++;
            array[right] = array[left];
        }
        array[right] = pivot;
        return right;
    }
}
