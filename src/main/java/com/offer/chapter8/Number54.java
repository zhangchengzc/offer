package com.offer.chapter8;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/6/4.
 */
public class Number54 {

    @Test
    public void test(){
        String str = "+-5";
        System.out.println(isNumber(str));
    }

    public boolean isNumber(String str){
        if(str == null || str.length()==0)
            return false;
        int index = 0;
        int length = str.length();
        if(str.charAt(0) == '+' || str.charAt(0) == '-')
            ++index;
        if(index == length)
            return false;
        boolean flag = true;
        index = scanStr(str,index);
        if(index != length){
            if(str.charAt(index) == '.'){
                ++index;
                if(index == length)
                    return false;
                index = scanStr(str,index);
                if(index < length && (str.charAt(index) == 'e' || str.charAt(index) == 'E'))
                    if(isExponential(str,index)){
                        flag = true;
                        index = length;
                    }else
                        flag = false;
            }else if(str.charAt(index) == 'e' || str.charAt(index) == 'E')
                if(isExponential(str,index)){
                    flag = true;
                    index = length;
                }else
                    flag = false;
            else
                return false;
        }
        return flag && index == length;
    }

    /**
     * 扫描字符串纯数字部分
     * @param str
     * @param index
     */
    private int scanStr(String str,int index){
        while(index != str.length() && str.charAt(index) - '0' >= 0 && str.charAt(index) - '0' <= 9)
            ++index;
        return index;
    }

    private boolean isExponential(String str,int index){
        ++index;
        if(index == str.length())
            return false;
        if(str.charAt(index) == '+' || str.charAt(index) == '-')
            ++index;
        if(index == str.length())
            return false;
        index = scanStr(str,index);
        return index == str.length();
    }
}
