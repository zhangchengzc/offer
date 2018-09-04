package com.offer.niuke;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/9/3.
 */
public class BTHeight {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        if(num < 3)
            System.out.println(num);
        int[] height = new int[num];
        int[] tree = new int[num];
        height[0] = 1;
        int max = 0;
        for (int i = 0; i < num-1; i++) {
            int parent = in.nextInt();
            int child = in.nextInt();
            tree[parent] += 1;
            if(tree[parent] < 3)
            {
                height[child] = height[parent] + 1;
            }
            max = max > height[child] ? max : height[child];
        }
        System.out.println(max);
    }
}
