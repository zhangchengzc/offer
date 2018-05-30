package com.offer.chapter6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcheng on 2018/5/24.
 */
public class Number41Second {

    @Test
    public void test(){
        System.out.println(getConstantNum(7));
    }

    /**
     *
     * @param num
     * @return
     */
    public List<List<Integer>> getConstantNum(int num){
        int end = num >> 1;
        int small = 1;
        int big = 2;
        int sum = small + big;
        List<List<Integer>> lists = new ArrayList<>();
        while(small <= end){
            if(sum < num){
                big += 1;
                sum += big;
            }else if(sum > num){
                sum -= small;
                small += 1;
            }else{
                List<Integer> list = new ArrayList<>();
                for(int i = small;i <= big; ++i)
                    list.add(i);
                lists.add(list);
                big += 1;
                sum += big;
            }
        }
        return lists;
    }
}
