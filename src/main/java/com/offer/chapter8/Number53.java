package com.offer.chapter8;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/6/1.
 */
public class Number53 {

    @Test
    public void test(){
        System.out.println(isMatch("bbbba",".*a*a"));
    }

    public boolean isMatch(String str,String pattern){
        if(str == null || pattern == null)
            return false;
        int index1 = 0;
        int index2 = 0;
        return isMatch(str,index1,pattern,index2);
    }

    /**
     * 通过两个索引来遍历字符串和正则表达式，在*地方判断正则表达式的索引是+0 ? +1 ? +2。同时注意下标越界的情况
     * @param str
     * @param index1
     * @param pattern
     * @param index2
     * @return
     */
    private boolean isMatch(String str,int index1,String pattern,int index2){
        if(index1 == str.length() && index2 == pattern.length())
            return true;
        if(index2 == pattern.length() && index1 != str.length())
            return false;
        if(index2 < pattern.length()-1 && pattern.charAt(index2+1) == '*'){
            if((pattern.charAt(index2) == '.' && index1 != str.length()) || (index1 != str.length() && str.charAt(index1) == pattern.charAt(index2)))
                return isMatch(str,index1+1,pattern,index2+2) ||
                        isMatch(str,index1+1,pattern,index2) || isMatch(str,index1,pattern,index2+2);//*匹配一次多次或者不匹配
            else
                return isMatch(str,index1,pattern,index2+2);
        }
        if(index1 != str.length() && (str.charAt(index1) == pattern.charAt(index2) || (pattern.charAt(index2) == '.' && index1 != str.length())))
            return isMatch(str,index1+1,pattern,index2+1);
        return false;
    }
}
