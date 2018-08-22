package com.offer.bishi.toutiao;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/12.
 */
public class Number4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] < b[i]){
                int j = i;
                for (; j < n; j++) {
                    max = max > a[j] ? max : a[j];
                    min = min < b[j] ? min : b[j];
                    if(max >= min)
                    {
                        min = Integer.MAX_VALUE;
                        max = Integer.MIN_VALUE;
                        break;
                    }
                }
                int temp = j-i;
                count += (temp + 1) * temp / 2;
                i = j;
            }
        }
        System.out.println(count);
    }
}
