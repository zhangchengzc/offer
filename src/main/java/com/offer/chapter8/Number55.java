package com.offer.chapter8;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangcheng on 2018/6/4.
 */
public class Number55 {

    @Test
    public void test(){
        String str = "go";
        System.out.println(getFirstAppearOnceCharacter(str));
    }


    /**
     * 使用Map来存放每个字符出现的次数
     * @param str
     * @return
     */
    public char getFirstAppearOnceCharacter(String str){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        for (int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == 1)
                return str.charAt(i);
        }
        return '#';
    }
}
