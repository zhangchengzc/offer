package com.offer.chapter5;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangcheng on 2018/5/16.
 */
public class Number35 {

    @Test
    public void test(){
        System.out.println(getFirstAppearOnce("abaccdeff"));
        System.out.println(removeRepeatCharacter("abaccdeff"));
    }

    /**
     * 使用HashMap来存储每个字符出现的次数，遍历两次数组即可找到第一个只出现一次的字符
     * @param input
     * @return
     */
    public char getFirstAppearOnce(String input){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            map.put(input.charAt(i),map.getOrDefault(input.charAt(i),0)+1);
        }
        for (int i = 0; i < input.length(); i++) {
            if(map.get(input.charAt(i)) == 1)
                return input.charAt(i);
        }
        return '*';
    }

    /**
     * 本题相关题目的第二题
     * @param input
     * @return
     */
    public String removeRepeatCharacter(String input){
        StringBuilder sl = new StringBuilder();
        Map<Character,Boolean> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if(!map.getOrDefault(input.charAt(i),false)){
                map.put(input.charAt(i),true);
                sl.append(input.charAt(i));
            }
        }
        return sl.toString();
    }
}
