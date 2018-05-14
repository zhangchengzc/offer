package com.offer.chapter5;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/11.
 */
public class Number32 {

    @Test
    public void test(){
        System.out.println(Count1InNumber(10));
    }

    /**
     *
     * @param num
     * @return
     */
    public int Count1InNumber(int num){
        String strNum = String.valueOf(num);
        int count = Count1InNumber(strNum);
        return count;
    }

    /**
     *
     * @param str
     * @return
     */
    private int Count1InNumber(String str){
        int firstNum = Character.getNumericValue(str.charAt(0));
        int length = str.length();
        if(length == 1 && firstNum == 0)
            return 0;
        if(length == 1 && firstNum > 0)
            return 1;
        int count1AtFirst = 0;
        if(firstNum == 1)
            count1AtFirst = Integer.valueOf(str.substring(1)) + 1;
        else
            count1AtFirst = (int) Math.pow(10,length-1);
        int countAfterFirst = firstNum * (length-1) * (int)Math.pow(10,length-2);
        int countLeft = Count1InNumber(str.substring(1));
        return count1AtFirst +countAfterFirst + countLeft;
    }
}
