package com.offer.chapter7;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/31.
 */
public class Number49 {

    @Test
    public void test(){
        try {
            System.out.println(strConvertLong("012"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * @param str
     * @return
     * @throws Exception
     */
    public long strConvertLong(String str)throws Exception{
        if(str == null || str.length() == 0)
            throw new Exception("illegal input string");
        int length = str.length();
        long result = 0;
        int temp = 0;
        for(int i = 0;i < length; ++i){
            if((temp = str.charAt(i) - '0') >= 0 && temp <= 9)
                result += (long) Math.pow(10,length-i-1) * temp;
            else
                throw new Exception("illegal input string");
        }

        return result;
    }
}
