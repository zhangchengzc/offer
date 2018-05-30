package com.offer.chapter6;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/30.
 */
public class Number46 {

    @Test
    public void test(){
        System.out.println(calculate(5));
        System.out.println(calculate2(5));
    }

    /**
     * 使用逻辑与来代替if else判断边界
     * @param n
     * @return
     */
    private int calculate(int n){
        int flag = 0;
        boolean b = (n > 1) && ((flag = calculate(n-1)) > 0);
        return flag+n;
    }

    /**
     * 使用异常来巧妙地返回边界值
     * @param n
     * @return
     */
    private int calculate2(int n){
        try{
            int[] array = new int[n-2];
            return n+calculate(n-1);
        }catch (Exception e){
            return 1;
        }
    }
}
