package com.offer.bishi.beike;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/18.
 */
public class Number2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        //int[][] arrange = new int[n][2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            int h = in.nextInt();
            //arrange[i][0] = array[i] + 1;
            map.put(array[i],array[i] + h -1);
        }
        int[] array2 = array.clone();
        Arrays.sort(array2);
        for (int i = 0; i < array.length; i++) {
            int j = 0;
            for (; array2[j] < array[i]; j++);
            int count = j;
            while(j < array.length){
                int max = 0;
                int k = j;
                int index = map.get(array2[k]);
                for (; k < array.length && array2[k] <= index; k++) {
                    max = max >= map.get(array2[k]) ? max : map.get(array2[k]);
                }
                j = k;
                if(k<array.length && max < array2[k])
                    break;
                else
                    continue;
            }
            System.out.print(j - count+" ");
        }

    }
}
