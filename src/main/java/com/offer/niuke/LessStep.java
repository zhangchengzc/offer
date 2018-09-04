package com.offer.niuke;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/9/3.
 */
public class LessStep {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] steps = new int[num];
        for (int i = 0; i < num; i++) {
            steps[i] = in.nextInt();
        }
        System.out.println(getLessStep(steps));
    }
    public static int getLessStep(int[] steps){
        int length = steps.length;
        int i=0,j=0;
        int count = 0;
        while(i < length){
            int max = 0;
            for (int k = 0; k < steps[i] && k+i+1 < length; k++) {
                if(max <= i+1+k+steps[i+1+k])
                {
                    max = i+1+k+steps[i+1+k];
                    j = i+1+k;
                }

            }
            if(max == 0)
                return -1;
            i = j;
            count++;
            if(steps[i] + i >= length)
                return ++count;
        }
        return count;
    }
}
