package com.offer.dynamic_programming;

/**
 * 给定一个矩阵m，从左上角开始每次只能向右走或者向下走
 * 最后达到右下角的位置，路径中所有数字累加起来就是路径和，
 * 返回所有路径的最小路径和
 * Created by zhangcheng on 2018/7/30.
 */
public class MinSteps {

    public static int[][] steps=new int[4][4];

    public static void main(String[] args) {
        int[][] arr = {{4,1,5,3},{3,2,7,7},{6,5,2,8},{8,9,4,5}};
        steps[3][3] = minSteps(arr, 3, 3);
        print(steps);
    }


    public static int minSteps(int[][] arr,int row,int col){
        //如果为起始位置，则直接返回
        if(row==0&&col==0){
            steps[row][col] = arr[row][col];
            return steps[row][col];
        }

        //计算到arr[row][col]的左面位置的值
        if(col>=1&&steps[row][col-1]==0){
            steps[row][col-1]=minSteps(arr, row, col-1);
        }
        //计算到arr[row][col]的上面位置的值
        if(row>=1&&steps[row-1][col]==0){
            steps[row-1][col]=minSteps(arr, row-1, col);
        }
        //如果为第一行，则直接加左面位置上的值
        if(row==0&&col!=0){
            steps[row][col] = arr[row][col]+steps[row][col-1];
        }else if(col == 0&&row!=0){
            //如果为第一列，则直接加上上面位置上的值
            steps[row][col] = arr[row][col]+steps[row-1][col];
        }else{
            //比较到达左面位置和到达上面位置的值的大小，加上两者的最大值
            steps[row][col] =arr[row][col]+min(steps[row][col-1],steps[row-1][col]);
        }
        return steps[row][col];
    }

    private static int min(int minSteps, int minSteps2) {
        return minSteps>minSteps2?minSteps:minSteps2;
    }


    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("到达arr["+i+"]["+j+"]的最大路径："+arr[i][j]);
            }
        }
    }
}
