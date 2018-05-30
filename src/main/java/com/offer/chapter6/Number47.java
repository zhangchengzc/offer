package com.offer.chapter6;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/30.
 */
public class Number47 {

    @Test
    public void test(){
        System.out.println(sum(8,7));
    }

    /**
     * 使用位运算来代替加法
     * @param n
     * @param m
     * @return
     */
    public int sum(int n,int m){
        int xor = n ^ m;
        int and = n & m;
        while(and != 0){
            and <<= 1;
            n = xor;
            m = and;
            xor = n ^ m;
            and = n & m;
        }
        return xor;
    }
}
