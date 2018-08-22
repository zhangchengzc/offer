package com.offer.bishi.pinduoduo;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/5.
 */
public class Number2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int len = str.length();
        int count = 0;
        for (int i = 1; i <= len-1 ; i++) {
            String str1 = str.substring(0,i);
            String str2 = str.substring(i,len);
            count += findCom(str1) * findCom(str2);
        }
        System.out.println(count);
    }
    public static int findCom(String str){
        int len = str.length();
        if(len == 1)
            return 1;
        if(str.charAt(len-1) == '0' && str.charAt(0) != '0')
            return 1;
        if(str.charAt(len-1) != '0' && str.charAt(0) == '0')
            return 1;
        if(str.charAt(len-1) == '0' && str.charAt(0) == '0')
            return 0;
        return len;

    }
}
