package com.offer.bishi.easynet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangcheng on 2018/8/9.
 */
public class CheckPassword {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = in.next();
        }
        for (int i = 0; i < N; i++) {
            if(judgeEachPasswd(str[i]))
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }

    public static boolean judgeEachPasswd(String str){
        if(str.length() < 8)
            return true;
        String regex = "^(?=.*[a-z])(?=.*[A-Z_-])(?=.*\\d)(?=.*[$@$!%*?&#+.^()_=\\[\\]{},<>/])[A-Za-z\\d$@$!%*?&#+.^()_=\\[\\]{},<>/]{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(!matcher.matches())
            return true;
        if(exitSeris(str))
            return true;
        return false;
    }
    public static boolean exitSeris(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9' && i < str.length()-2){
                if(isSeris(str,i))
                    return true;
            }
        }
        return false;
    }

    public static boolean isSeris(String str,int i){
        char c1 = str.charAt(i);
        char c2 = str.charAt(i+1);
        char c3 = str.charAt(i+2);
        if(c2 <= '0'|| c2 >= '9' || c3 <= '0' || c3 >= '9')
            return false;
        int n1 = c1 - '0';
        int n2 = c2 - '0';
        int n3 = c3 - '0';
        if(n3 - n2 == n2 - n1)
            return true;
        else
            return false;
    }

}
