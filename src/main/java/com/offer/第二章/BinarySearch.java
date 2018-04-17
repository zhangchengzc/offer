package com.offer.第二章;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/7.
 */
public class BinarySearch {

    @Test
    public void test(){
        int[] array = {1,2,3,5,6,7};
        System.out.println(binarySearch(array,0,array.length-1,7));
    }

    public int binarySearch(int[] array,int left,int right,int num)
    {
        if(left<=right)
        {
            int mid = (left+right)/2;
            if(array[mid] == num)
                return mid;
            else if(array[mid] < num)
                return binarySearch(array,mid+1,right,num);
            else
                return binarySearch(array,left,mid-1,num);
        }else
            return -1;
    }
}
