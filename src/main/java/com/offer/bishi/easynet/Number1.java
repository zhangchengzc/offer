package com.offer.bishi.easynet;


import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/11.
 */
public class Number1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] interest = new int[n];
        int[] wake = new int[n];
        for (int i = 0; i < n; i++) {
            interest[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wake[i] = in.nextInt();
        }
        System.out.println(getMax(interest,wake,n,k));

    }
    public static int getMax(int[] interest,int[] wake,int n,int k){
        int sum = 0;
        int max = 0;
        int add = 0;
        for (int i = 0; i < n; i++) {
            if(wake[i] == 1)
                sum += interest[i];
        }
        for (int i = 0; i < k && i < n; i++) {
            if(wake[i] == 0)
                add += interest[i];
        }
        max = add;
        for (int i = 0; i + k < n; i++) {
            if(wake[i] == 0)
                add -= interest[i];
            if(wake[i+k] == 0)
                add += interest[i + k];
            max = add > max ? add : max;
        }
        return sum + max;
    }
}
