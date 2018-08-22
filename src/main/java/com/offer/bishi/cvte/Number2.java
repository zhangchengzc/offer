package com.offer.bishi.cvte;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcheng on 2018/7/20.
 */
public class Number2 {


    @Test
    public void test(){
        String str = "aaa";
        StringBuffer stringBuffer = new StringBuffer(str);
        StringBuffer s2 = stringBuffer.reverse();
        System.out.println((stringBuffer.length()));
        int[] num = {1,1,2,2,3,3,4,4,4};
        System.out.println(findAboveQuarter(num));
    }
    public List<Integer> findAboveQuarter(int[] num){
        int num1 = -1,num2 = -1,num3 = -1;
        int count1 = 0,count2 = 0,count3 = 0;
        for(int n : num){
            if(count1 == 0 || num1 == n){
                ++count1;
                num1 = n;
            }else if (count2 == 0 || num2 == n){
                ++count2;
                num2 = n;
            }else if(count3 == 0 || num3 == n){
                ++count3;
                num3 = n;
            }else{
                --count1;
                --count2;
                --count3;
            }
        }
        List<Integer> list = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        count3 = 0;
        for(int n : num){
            if(num1 == n)
                ++count1;
            else if(num2 == n)
                ++count2;
            else if(num3 == n)
                ++count3;
        }
        if(count1 > num.length / 4)
            list.add(num1);
        if(count2 > num.length /4)
            list.add(num2);
        if(count3 > num.length /4)
            list.add(num3);
        return list;
    }
}
