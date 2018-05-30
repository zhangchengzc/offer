package com.offer.chapter6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhangcheng on 2018/5/28.
 */
public class Number42Second {

    @Test
    public void test(){
        try {
            System.out.println(leftRotate("abcdef", 2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 类似First中，先整体逆置字符串，然后根据index的位置，分别逆置被index隔开的两个字符串。{@link com.offer.chapter6.Number42First#reverseWords(String)}
     * @param inputStr
     * @param index
     * @return
     */
    public String leftRotate(String inputStr,int index) throws Exception{
        if(inputStr == null)
            return null;
        if(inputStr.length() == 0)
            return "";
        if(inputStr.length() < index)
            throw new Exception("字符串长度不够");
        StringBuilder sl = new StringBuilder(inputStr);
        sl.reverse();
        int pivot = sl.length() - index;
        int right = sl.length();
        StringBuilder temp = new StringBuilder(inputStr.length());
        temp.append(sl.substring(0,pivot));
        temp.reverse();
        sl.append(temp);
        temp.delete(0,temp.length());
        temp.append(sl.substring(pivot,right));
        temp.reverse();
        sl.append(temp);
        sl.delete(0,right);
        return sl.toString();
    }
}
