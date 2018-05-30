package com.offer.chapter6;

import org.junit.Test;


/**
 * Created by zhangcheng on 2018/5/28.
 */
public class Number42First {

    @Test
    public void test(){
        System.out.println(reverseWords(" "));
    }

    /**
     * 先逆置整个大字符串，然后在逐个逆置无空格的字符串。
     * @param inputWords
     * @return
     */
    public String reverseWords(String inputWords){
        if(inputWords == null || inputWords.length() == 0)
            return null;
        if(inputWords.equals(" "))
            return " ";
        StringBuilder sl = new StringBuilder(inputWords);
        sl.reverse();
        String[] str = sl.toString().split(" ");
        sl.delete(0,sl.length());
        for(int i = 0;i < str.length; ++i){
            sl.append(reverseWord(str[i]));
            sl.append(" ");
        }
        sl.deleteCharAt(sl.length()-1);
        return sl.toString();
    }

    /**
     * 逆置一个字符串
     * @param str
     * @return
     */
    private String reverseWord(String str){
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length >> 1;++i){
            char temp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = temp;
        }
        return String.valueOf(chars);
    }
}
