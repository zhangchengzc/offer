package com.offer.bishi.pinduoduo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zhangcheng on 2018/8/5.
 */
public class Number3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[][] array = new int[num+1][num+1];
        array[0][0] = num;
        array[0][1] = in.nextInt();
        in.nextLine();
        for (int i = 1; i < num+1; i++) {
            String str = in.nextLine();
            char[] ch = str.toCharArray();
            for (int j = 0,k = 0; j < ch.length; j++) {
                if(ch[j] != ' ')
                {
                    array[i][k] = ch[j] - '0';
                    k++;
                }

            }
        }
        System.out.println(core(array));
    }
    public static int core(int[][] array){
        if(array == null || array[0].length < 2)
            return -1;
        int N = array[0][0];
        int user = array[0][1];
        boolean flag = check(N,array);
        if(!flag)
            return -1;
        int[] countSum = new int[N];
        Set<Integer> friendSet = new HashSet<>();
        int[] friendArr = array[user+1];
        for (int i = 0; i < friendArr.length ; i++) {
            friendSet.add(friendArr[i]);
        }
        for (int i = 0; i < N; i++) {
            if(friendSet.contains(i) || i == user)
                continue;
            int count = 0;
            int[] tmp = array[i+1];
            for (int j = 0; j < tmp.length; j++) {
                if(friendSet.contains(tmp[j]))
                    count++;
            }
            countSum[i] = count;
        }
        int target = 0;
        for (int i = 0; i < countSum.length; i++) {
            if(countSum[i] > countSum[target])
                target = i;
        }
        return target == 0 ? -1 : target;
    }

    public static boolean check(int N, int[][] arr){
        if(arr.length != N+1)
            return false;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] >= N)
                    return false;
            }
        }
        return true;
    }
}
