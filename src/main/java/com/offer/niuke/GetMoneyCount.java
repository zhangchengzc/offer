package com.offer.niuke;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/28.
 */
public class GetMoneyCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        long[] count = new long[num+1];
        for (int i = 0; i <= num; i++) {
            count[i] = 1;
        }
        int[] money = {5,10,20,50,100};
        for (int i = 0; i < money.length ; i++) {
            int index = 1;
            while(index <= num){
                if(index >= money[i])
                    count[index] += count[index-money[i]];
                index++;
            }
        }

        System.out.println(count[num]);
    }
}