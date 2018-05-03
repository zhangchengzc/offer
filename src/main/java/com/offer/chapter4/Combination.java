package com.offer.chapter4;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/5/2.
 */
public class Combination {

    @Test
    public void test(){
        String str = "abc";
        combination(str);
    }
    /**
     * 求一个字符串的任意组合
     * @param str
     */
    public void combination(String str){
        if(str == null || str.length() == 0)
            return;
        StringBuilder sl = new StringBuilder();
        for(int i = 1; i <= str.length(); ++i){
            comb(str.toCharArray(),i,0,sl);
        }
    }

    /**
     * 求字符数组个数为m的组合
     * @param ch
     * @param m
     * @param left
     * @param sl
     */
    private void comb(char[] ch,int m,int left,StringBuilder sl){
        if(m == 0)
        {
            System.out.println(sl.toString());
            return;
        }
        if(left == ch.length)
            return;
        sl.append(ch[left]);
        comb(ch,m-1,left+1,sl);
        sl.deleteCharAt(sl.length()-1);
        comb(ch,m,left+1,sl);
    }
}
