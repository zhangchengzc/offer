package com.offer.chapter3;


import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/8.
 */
public class Number11 {

    @Test
    public void test(){
        System.out.println(power(2.0,2));
    }

    public double power(double base,int exponent){
        if(Double.compare(base,0.0) == 0 && exponent<0)
        {
            System.out.println("0的指数不能为负");
        }
        int exp = Math.abs(exponent);
        double result = 1.0;
        for(int i = 1;i <= exp; ++i)
            result *= base;
        if(exponent < 0)
            result = 1.0 / result;
        return result;
    }
}
