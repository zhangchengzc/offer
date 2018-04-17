package com.offer.第二章;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangcheng on 2018/4/7.
 */
public class MergeSort {

    @Test
    public void test(){
        int[] num = {4,5,7,8,1,2,2,3,6};
        mergeSort(num,new int[num.length],0,num.length-1);
        System.out.println(Arrays.toString(num));
    }

    public void mergeSort(int[] array,int[] temp,int left,int right)
    {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(array,temp,left,mid);
            mergeSort(array,temp,mid+1,right);
            merge(array,temp,left,mid+1,right);
        }

    }

    public void merge(int[] array,int[] temp,int left,int rigthlow,int right){
        int leftEnd = rigthlow - 1;
        int tempPos = left;
        int length = right - left + 1;
        while (left <= leftEnd && rigthlow <= right) {
            if (array[left] <= array[rigthlow])
                temp[tempPos++] = array[left++];
            else
                temp[tempPos++] = array[rigthlow++];
        }

        while (left <= leftEnd)
            temp[tempPos++] = array[left++];
        while (rigthlow <= right)
            temp[tempPos++] = array[rigthlow++];
        for (int i = 0; i < length; ++i) {
            array[right] = temp[right];
            right--;
        }

    }
}
