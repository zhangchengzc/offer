package com.offer.pack;

/**
 * Created by zhangcheng on 2018/8/28.
 */
public class MultiplePack {

    int N = 4;
    int V = 8;
    int[] w = {0,2,3,4,5};
    int[] v = {0,3,4,5,6};
    int[][] F = new int[N+1][V+1];
    int[] F2 = new int[V+1];

    public void completePack(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V ; j++) {
                if(j < w[i])
                    F[i][j] = F[i-1][j];
                else
                    F[i][j] = F[i-1][j] > F[i][j-w[i]]+v[i] ? F[i-1][j] : F[i][j-w[i]] + v[i];
            }
        }
    }

    public void completePack2(){
        for (int i = 1; i <= N; i++) {
            for (int j = w[i]; j <= V; j++) {
                if(F2[j] < F2[j-w[i]]+v[i])
                    F2[j] = F2[j-w[i]] + v[i];
            }
        }
    }

    public static void main(String[] args) {
        MultiplePack test = new MultiplePack();
        test.completePack();
        test.completePack2();
        System.out.println(test.F[4][8]);
        System.out.println(test.F2[8]);
    }




}
