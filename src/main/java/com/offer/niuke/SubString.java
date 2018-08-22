package com.offer.niuke;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/3.
 */
public class SubString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        if(str1 == null || str2 == null)
            System.out.println(false);
        if(str2 == "")
            System.out.println("Yes");
        System.out.println(isSubstring(str1,str2));
    }

    public static String isSubstring(String str1,String str2){
        int index = 0;
        for(int i = 0; i < str2.length(); ++i){
            if(index >= str1.length())
                return "No";
            if(str2.charAt(i) == str1.charAt(index)){
                ++index;
            }else {
                --i;
                ++index;
            }
        }
        if(index <= str1.length())
            return "Yes";
        else
            return "No";
    }
}
