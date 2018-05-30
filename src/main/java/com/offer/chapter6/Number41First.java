package com.offer.chapter6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangcheng on 2018/5/24.
 */
public class Number41First {

    @Test
    public void test(){
        int[] array = {1,2,4,7,11,15};
        System.out.println(getTwoNum(array,90));
    }

    /**
     *
     * @param array
     * @param sum
     * @return
     */
    public List<Integer> getTwoNum(int[] array,int sum){
        if(array == null || array.length == 0)
            return null;
        int left = 0,right = array.length-1;
        List<Integer> list = new ArrayList<>();
        while(left < right){
            if(array[left] + array[right] < sum)
                ++left;
            else if(array[left] + array[right] > sum)
                --right;
            else{
                list.add(array[left]);
                list.add(array[right]);
                break;
            }
        }
        return list;
    }
}
