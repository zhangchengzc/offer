package com.offer.bishi;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/28.
 */
public class Main {
    static int N = 1000;
    static int[][] pic;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        pic = new int[n][n];
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if((temp = in.nextInt()) == -1)
                    pic[i][j] = temp + N + 1;
                else
                    pic[i][j] = temp;
            }
        }
        dij(p, pic);
    }

    public static void dij(int vs, int[][] pic) {
        int length = pic[0].length;
        int[] pre = new int[length];
        int[] min = new int[length];
        boolean[] find = new boolean[length];

        int temp = 0;

        for (int i = 0; i < min.length; i++) {
            pre[i] = i;
            min[i] = pic[vs][i];
            find[i] = false;
        }

        find[vs] = true;

        for (int v = 1; v < pic.length; v++) {

            // 每次循环求得距离vs最近的节点vnear和最短距离min
            int mindis = N;
            for (int j = 0; j < pic.length; j++) {
                if (!find[j] && min[j] < mindis) {
                    mindis = min[j];
                    temp = j;
                }
            }
            find[temp] = true;

            for (int k = 0; k < pic.length; k++) {
                if (!find[k] && (mindis + pic[temp][k]) < min[k]) {
                    pre[k] = temp;
                    min[k] = mindis + pic[temp][k];
                }
            }
        }

        for (int i = 1; i < length-1; i++) {
            System.out.print(min[i]+",");
        }
        System.out.println(min[length-1]);

    }
}
