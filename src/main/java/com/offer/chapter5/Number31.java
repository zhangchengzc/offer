package com.offer.chapter5;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/11.
 */
public class Number31 {

    @Test
    public void test(){
        int[] num = {1,-2,3,10,-4,7,2,-5};
        try {
            System.out.println(getMaxSubArraySum(num));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 使用一个sum变量存储目前连续子数组和
     * 一个max变量存储目前连续子数组最大和
     * @param num
     * @return
     * @throws Exception
     */
    public int getMaxSubArraySum(int[] num) throws Exception{
        if(num == null || num.length == 0)
            throw new Exception("Input num is illegal");
        int max = 0;//存放目前连续子数组最大和
        int sum = 0;//存放目前连续子数组和
        for(int i = 0; i < num.length; ++i){
            if(sum + num[i] < num[i]){
                sum = num[i];
                max = max > num[i] ? max : num[i];
            }else if(sum + num[i] < max){
                sum += num[i];
            }else{
                sum += num[i];
                max = sum;
            }
        }
        return max;
    }
}
