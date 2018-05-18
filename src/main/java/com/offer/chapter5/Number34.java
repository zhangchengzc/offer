package com.offer.chapter5;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/16.
 */
public class Number34 {


    @Test
    public void test(){
        System.out.println(getUglyNumber(11));
    }

    /**
     * 每一个新得到的丑数都是数组中某个数*2或者*3或者*5得到的
     * @param numbers
     * @return
     */
    public int getUglyNumber(int numbers){
        int[] num = new int[numbers];
        num[0] = 1;
        int t2 = 0,t3 = 0,t5 = 0;
        int count = 1;
        while(count < numbers){
            int min = minOfThree(num[t2]*2,num[t3]*3,num[t5]*5);
            num[count] = min;
            while(num[t2] * 2 <= min)
                ++t2;
            while(num[t3] * 3 <= min)
                ++t3;
            while(num[t5] * 5 <= min)
                ++t5;
            ++count;
        }
        return num[numbers-1];

    }

    public int minOfThree(int n1,int n2,int n3){
        return n1 > n2 ? (n2 > n3 ? n3 : n2) : (n1 > n3 ? n3 : n1);
    }
}
