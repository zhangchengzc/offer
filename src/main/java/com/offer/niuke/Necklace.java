package com.offer.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/9/4.
 */
public class Necklace {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.next();
            int len = str.length();
            str = str + str;
            boolean flag = false;
            for (int i = 5; i <= len ; i++) {
                for (int j = 0; j < len; j++) {
                    if(isMatch(str,j,i)){
                        System.out.println(len - i);
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
        }

    }

    public static boolean isMatch(String str,int start,int len){
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(i,false);
        }
        for (int i = start; i < start+len; i++) {
            int index;
            if((index = str.charAt(i) - 'A') <= 4){
                map.put(index,true);
            }
        }
        return map.get(0) && map.get(1) && map.get(2) && map.get(3) && map.get(4);
    }
}
