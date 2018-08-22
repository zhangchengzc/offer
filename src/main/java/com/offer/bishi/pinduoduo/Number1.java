package com.offer.bishi.pinduoduo;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/5.
 */
public class Number1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        if(str == null || str == "")
            System.out.println();
        int length = str.length();
        int k = length / 4;
        char[][] array = new char[k+1][k+1];
        for (int i = 0; i < k+1; i++) {
            for (int j = 0; j < k+1; j++) {
                array[i][j] = ' ';
            }
        }
        for (int i = 0; i <= k; i++) {
            array[0][i] = str.charAt(i);
        }
        for (int i = 1; i <=k ; i++) {
            array[i][k] = str.charAt(k+i);
        }
        for (int i = 0; i <= k-1 ; i++) {
            array[k][i] = str.charAt(3 * k-i);
        }
        for (int i = 1; i <= k-1 ; i++) {
            array[i][0] = str.charAt(4*k-i);
        }
        for (int i = 0; i < k+1; i++) {
            for (int j = 0; j < k+1; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }

    }
}
