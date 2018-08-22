package com.offer.chapter3;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 * Created by zhangcheng on 2018/4/8.
 */
public class Number12 {

    @Test
    public void test()
    {
        print1ToN2(2);
    }

    /**
     * 使用全排列的方法打印
     * @param n
     */
    public void print1ToN2(int n){
        if(n <= 0)
            return;
        char[] digit = new char[n];
        for(int i = 0;i < 10; ++i)
        {
            digit[0] = (char)('0'+i);
            fullArrangement(digit,0);
        }
    }

    public void fullArrangement(char[] digit,int index){
        if(index == digit.length-1)
        {
            System.out.println(Integer.valueOf(String.valueOf(digit)));
            return;
        }
        for(int i=0;i<10;++i)
        {
            digit[index+1] = (char)('0'+i);
            fullArrangement(digit,index+1);
        }
    }

    /**
     * 使用字符数组方法打印
     * @param n
     */
    public void print1ToN(int n){
        if(n < 0)
            return;
        char[] digit = new char[n];
        for(int i = 0;i < n;++i)
            digit[i] = '0';
        while(addOne(digit)){
            System.out.println(String.valueOf(digit));
        }
    }

    public boolean addOne(char[] digit)
    {
        int carry = 0;
        for(int i = digit.length-1;i >= 0; --i)
        {
            int sum = digit[i] - '0'  + carry;
            if(i == digit.length-1)
                sum++;
            if(sum >=10)
            {
                if(i == 0)
                    return false;
                else{
                    carry = 1;
                    digit[i] = '0';
                }
            }else
            {
                digit[i] = (char)('0' + sum);
                break;
            }
        }
        return true;
    }
}
