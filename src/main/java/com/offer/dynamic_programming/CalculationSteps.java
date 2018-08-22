package com.offer.dynamic_programming;

/**
 * 动态规划
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。
 * Created by zhangcheng on 2018/7/30.
 */
public class CalculationSteps {
    //动态规划表，用来记录到达i级台阶的方法数
    public static int[] steps = new int[11];

    public static void main(String[] args) {
        steps[10] = calStep(10);

        for (int i = 0; i < steps.length; i++) {
            System.out.print(steps[i]+" ");
        }
        System.out.println();
        System.out.println(steps[10]);
    }

    //计算到达i级台阶的方法数
    public static int calStep(int n){
        //如果为第一级台阶或者第二级台阶 则直接返回n
        if(n==1||n==2){
            return n;
        }
        //计算到达n-1级台阶的方法数
        if(steps[n-1]==0){
            steps[n-1] = calStep(n-1);
        }
        //计算到达n-2级台阶的方法数
        if(steps[n-2] == 0){
            steps[n-2] = calStep(n-2);
        }
        //到达第n级台阶=到达n-1级台阶+到达n-2级台阶
        return steps[n-1]+steps[n-2];
    }
}
