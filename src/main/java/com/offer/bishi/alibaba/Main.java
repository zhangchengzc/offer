package com.offer.bishi.alibaba;

/**
 * 物流配送
 * Created by zhangcheng on 2018/8/8.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static int minstep = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        in.nextLine();//清除缓冲区的换行

        Point[] points = new Point[num];
        for (int i = 0; i < num; i++) {
            String[] temp = in.nextLine().trim().split(",");
            points[i] = new Main().new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
        //起始结点
        Point start = new Main().new Point(0, 0);

        fullArrangement(start, points, 0, 0);

        System.out.println(minstep);
    }

    /**
     * 基于全排列的思想
     * @param start
     * @param points
     * @param sum
     * @param countStep
     */
    public static void fullArrangement(Point start, Point[] points, int sum, int countStep) {

        if (countStep == points.length) {
            sum += start.getDistance(new Main().new Point(0, 0));// 回到起点
            if (sum < minstep) {
                minstep = sum;
            }
            return;
        }
        //每次递归调用该循环遍历每个结点判断有没有访问过
        for (int i = 0; i < points.length; i++) {
            if (!points[i].isVisited) {
                points[i].isVisited = true;
                fullArrangement(points[i], points, sum + start.getDistance(points[i]), countStep + 1);
                points[i].isVisited = false;
            }
        }

    }

    class Point {
        public int x;
        public int y;
        public boolean isVisited;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.isVisited = false;
        }

        public int getDistance(Point point) {
            return Math.abs(point.x - this.x) + Math.abs(point.y - this.y);
        }
    }
}
