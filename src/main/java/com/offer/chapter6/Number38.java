package com.offer.chapter6;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/21.
 */
public class Number38 {

    @Test
    public void test(){
        System.out.println(getCount(new int[]{3,3,3,3,3},3));
    }

    /**
     * 本题使用二分查找法查找数字在数组中第一次出现的位置和最后一次出现的位置
     * @param array
     * @param num
     * @return
     */
    public int getCount(int[] array,int num){
        if(array == null || array.length == 0)
            return 0;
        int first = getFirstIndex(array,num,0,array.length-1);
        int end = getEndIndex(array,num,0,array.length-1);
        if(first == -1 || end == -1)
            return 0;
        else
            return end - first + 1;
    }
    /**
     * 使用二分查找法查找数字第一次出现的位置
     * @param array
     * @param num
     * @param left
     * @param right
     * @return
     */
    private int getFirstIndex(int[] array,int num,int left,int right){
        if(left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] < num)
                return getFirstIndex(array, num, mid + 1, right);
            else if (array[mid] > num || (mid > 0 && array[mid - 1] == num))
                return getFirstIndex(array, num, left, right - 1);
            else
                return mid;
        }else
            return -1;
    }
    /**
     * 使用二分查找法查找数字出现的最后的位置
     * @param array
     * @param num
     * @param left
     * @param right
     * @return
     */
    private int getEndIndex(int[] array,int num,int left,int right){
        if(left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] > num)
                return getEndIndex(array, num, left, mid - 1);
            else if(array[mid] < num || (mid < array.length-1 && array[mid+1] == num))
                return getEndIndex(array,num,mid+1,right);
            else
                return mid;
        }else
            return -1;
    }
}
