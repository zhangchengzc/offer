package com.offer.chapter4;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/24.
 */
public class Number28 {

    @Test
    public void test(){
        String str = "abcd";
        fullArrangeMent(str.toCharArray(),0);
    }

    /**
     * 递归求全排列
     * @param ch
     * @param index
     */
    public void fullArrangeMent(char[] ch,int index){
        if(ch.length-1 == index){
            System.out.println(String.valueOf(ch));
            return;
        }else{
            for(int i = index ; i < ch.length ; ++i){
                swap(ch,index,i);
                fullArrangeMent(ch,index+1);
                swap(ch,i,index);
            }
        }
    }

    /**
     * 交换下标为index和i对应的字符。
     * @param ch
     * @param index
     * @param i
     */
    private void swap(char[] ch,int index,int i){
        char temp = ch[i];
        ch[i] = ch[index];
        ch[index] = temp;
    }


}
