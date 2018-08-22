package com.offer.bishi.easynet;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/11.
 */
public class Number2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = in.nextInt();
        }
        int sum = 0;
        int[] arr3 = new int[N];
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            arr3[i] = sum;
        }
        for (int i = 0; i < m; i++) {
            System.out.println(binarySearch(arr3,0,arr.length-1,arr2[i]));
        }
        /*for (int i = 0; i < m; i++) {
            int temp = arr2[i];
            for (int j = 0; j < N; j++) {
                if(temp - arr[j] <= 0)
                {
                    System.out.println(j+1);
                    break;
                }else
                    temp = temp - arr[j];
            }
        }*/
    }

    public static int binarySearch(int[] arr,int left,int right, int num){
        if(left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] >= num && (middle == 0 || arr[middle - 1] < num))
                return middle+1;
            else if (arr[middle] < num)
                return binarySearch(arr, middle + 1, right, num);
            else
                return binarySearch(arr, left, middle - 1, num);
        }else
            return -1;
    }
}
