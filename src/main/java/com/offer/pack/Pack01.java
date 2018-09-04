package com.offer.pack;

/**
 * Created by zhangcheng on 2018/8/28.
 */
public class Pack01 {
    int N = 4;
    int V = 8;
    int[] w;
    int[] v;
    int[][] F = new int[N+1][V+1];
    public void pack01(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V ; j++) {
                if(j < w[i])
                    F[i][j] = F[i-1][j];
                else
                    F[i][j] = F[i-1][j] > F[i-1][j - w[i]] + v[i] ? F[i-1][j] : F[i-1][j-w[i]] + v[i];
            }
        }
    }
}
