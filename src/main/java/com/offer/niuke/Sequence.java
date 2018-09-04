package com.offer.niuke;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/9/3.
 */
public class Sequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            double n = in.nextInt();
            int m = in.nextInt();
            double sum = n;
            for (int i = 1; i < m; i++) {
                sum += Math.sqrt(n);
                n = Math.sqrt(n);
            }
            long result = Math.round(sum * 100);
            StringBuilder sl = new StringBuilder(String.valueOf(result));
            sl.insert(sl.length()-2,'.');
            System.out.println(sl.toString());
        }
    }
}
