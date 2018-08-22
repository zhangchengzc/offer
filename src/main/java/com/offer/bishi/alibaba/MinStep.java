package com.offer.bishi.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/7.
 */
public class MinStep {

    static int INT_MAX = Integer.MAX_VALUE; // maximum (signed) int value
    static int minStep = INT_MAX;
    static int[][] map;
    static int[][] result;
    public static void dfs(int start, int end, int N ,int M ,int dis ,int steps)
    {
        if (steps == M)
        {
            //刚刚好 M步 到达所需要的end 且路径较短，则更新数值
            if (start == end && dis < minStep)
                minStep = dis;
            return;
        }

        for (int next = 0; next < N; next++)
        {
            if (next == start)
                continue;
            dfs(next, end, N, M, dis + map[start][next],steps+1);
        }
    }
    public static int[][] solution(int N, int M)
    {
        result = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // 求从 i -> j 的最短路径
                dfs(i, j, N, M, 0, 0);
                result[i][j] = minStep;
                minStep = INT_MAX;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int N, M;

        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        int tmp;
        map = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                tmp = in.nextInt();
                map[i][j] = tmp;
            }
        }

        solution(N, M);
        System.out.println(Arrays.deepToString(result));

    }
}
