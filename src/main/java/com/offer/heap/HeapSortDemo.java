package com.offer.heap;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangcheng on 2018/3/13.
 */
public class HeapSortDemo{
    public static void main(String[] args) {
       String str = "1234";
       char[] ch = str.toCharArray();
       long sum = 0;
       for(int i = ch.length-1; i >= 0; --i){
           sum += (ch[i]-'0')*Math.pow(10,ch.length-1-i);
        }
        System.out.println(sum);


        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set);
    }
}
