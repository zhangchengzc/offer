package com.offer.chapter5;

import org.junit.Test;

import java.util.*;

/**
 * Created by zhangcheng on 2018/5/3.
 */
public class Number29 {

    @Test
    public void test(){
        int[] num = {1,2,3,2,2,2,5,4,2};
        System.out.println(findAppearOverHalf3(num));
    }


    /**
     * 快排的partition方法可以在O(n)的时间里查找数组中第k大的数
     * @param num
     * @return
     */
    public int findAppearOverHalf2(int[] num){
        if(checkInvalidArray(num))
            return -1;
        int[] numCopy = num.clone();
        int middle = numCopy.length >> 1;
        int index = partition(numCopy,0,numCopy.length-1);
        while(index != middle)
        {
            if(index > middle)
                index = partition(numCopy,0,index-1);
            else
                index = partition(numCopy,index+1,numCopy.length-1);
        }
        return numCopy[index];
    }

    /**
     * 快排的partition算法可以找到第k个大的数
     * @param num
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] num, int left, int right){
        int pivot = num[left];
        while (left < right){
            while(left < right && num[right] >= pivot)
                right--;
            num[left] = num[right];
            while (left < right && num[left] <= pivot)
                left++;
            num[right] = num[left];
        }
        num[right] = pivot;
        return right;
    }
    private boolean checkInvalidArray(int[] num){
        return num == null || num.length == 0;
    }

    /**
     * 因为出现次数超过数组长度一半的数字比其他数字出现次数和还要多。
     * @param num
     * @return
     */
    public int findAppearOverHalf3(int[] num){
        if(checkInvalidArray(num))
            return -1;
        int index = 0,count = 0;
        for (int i = 0; i < num.length; i++) {
            if(count == 0){
                index = i;
                count++;
            }else if(num[i] == num[index]){
                count++;
            }else
                count--;
        }
        return num[index];
    }

    /**
     * 在O(n)时间内返回出现次数超过数组一半的数（因为hash查找的时间复杂度是O(1)）
     * @param num
     * @return
     */
    public int findAppearOverHalf(int[] num)
    {
        if(num == null || num.length == 0)
            return -1;
        int half = num.length >> 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < num.length; ++i){
            map.put(num[i],map.getOrDefault(num[i],0)+1);
            if(map.get(num[i]) >= half)
                return num[i];
        }
        return -1;
    }
}
