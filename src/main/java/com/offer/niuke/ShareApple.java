package com.offer.niuke;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/9/3.
 */
public class ShareApple {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] apples = new int[num];
        int sum = 0;
        for (int i = 0; i < num; i++) {
            apples[i] = in.nextInt();
            sum += apples[i];
        }
        if(sum % num != 0){
            System.out.println(-1);
            return;
        }
        int mid = sum / num;
        int count = 0;
        for (int i = 0; i < num; i++) {
            if((mid - apples[i]) % 2 != 0)
            {
                System.out.println(-1);
                return;
            }
            if(mid > apples[i]){
                count += (mid-apples[i]) >> 1;
            }
        }
        System.out.println(count);
    }
}
