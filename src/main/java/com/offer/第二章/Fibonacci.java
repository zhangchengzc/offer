package com.offer.第二章;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/8.
 */
public class Fibonacci {

    @Test
    public void test(){
        System.out.println(fib(5));
    }

    public int fib(int n)
    {
        int x = 0,y = 1;
        int sum = 1;
        for(int i = 3;i <= n;++i)
        {
            sum = x + y;
            x = y;
            y = sum;
        }

        return sum;
    }
}
