package com.offer.chapter6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcheng on 2018/5/23.
 */
public class Number40 {

    @Test
    public void test(){
        System.out.println(getAppearOnce(new int[]{2,4,3,6,3,2,5,5}));
    }

    /**
     * 若数组中只有一个数只出现一次，其他数出现两次，可以从头到尾依次异或结果即是只出现一次的那个数。
     * 对于存在两个数出现一次的情况，需要通过第一次遍历异或结果中最右边的1来将数组分别分为两个部分然后采用上述思路再遍历一次既得到两个数
     * @param array
     * @return
     */
    public List<Integer> getAppearOnce(int[] array){
        List<Integer> list = new ArrayList<>();
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            num ^= array[1];
        }
        int index = num - (num & (num-1));
        boolean flag1 = false,flag2 = false;
        int num1 = 0,num2 = 0;
        for(int i = 0; i< array.length;i++)
        {
            if(!flag1 && ((array[i] & index) == 0)){
                num1 = array[i];
                flag1 = true;
            }else if(!flag2 && ((array[i] & index) == index)){
                num2 = array[i];
                flag2 = true;
            }else if(flag1 && ((array[i] & index) == 0)){
                num1 ^= array[i];
            }else
                num2 ^= array[i];
        }
        list.add(num1);
        list.add(num2);
        return list;
    }
}
