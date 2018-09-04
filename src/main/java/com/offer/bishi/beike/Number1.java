package com.offer.bishi.beike;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/18.
 */
public class Number1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int count = 0;
        System.out.println(getCount(N,M,count));
    }

    public static int getCount(int n,int m,int count){
        if(n >= m) {
            count += n - m;
            return count;
        }
        if(m % 2 == 0)
            return getCount(n,m >> 1,count+1);
        else
            return getCount(n,m+1,count+1);
    }
}
