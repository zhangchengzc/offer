package com.offer.chapter2;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/8.
 */
public class Number10 {

    @Test
    public void test(){
        System.out.println(Integer.toBinaryString(-7));
        System.out.println(count(-7));
    }


    public int count(int num)
    {
        int count = 0;
        while(num != 0)
        {
            count++;
            num = (num-1)&num;
        }
        return count;
    }
}
