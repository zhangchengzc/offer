package com.offer.bishi.pinduoduo;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/8/5.
 */
public class Number4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        for (int i = 0; i < len; i++) {
            list.add(in.nextInt());
        }
        int count = 0;
        while (list.size() != 1){
            if(asc(list) > desc(list)){
                List<Integer> list1 = new ArrayList<>();
                for (int i = 1; i < list.size()-1; i++) {
                    if(list.get(i-1) >= list.get(i+1))
                        list1.add(list.get(i));
                }
                list1.add(list.get(list.size()-1));
                list = list1;
                count++;
            }else{
                List<Integer> list1 = new ArrayList<>();
                for (int i = 1; i < list.size()-1; i++) {
                    if(list.get(i-1) <= list.get(i+1))
                        list1.add(list.get(i));
                }
                list1.add(list.get(0));
                list = list1;
                count++;
            }
        }
        count++;
        System.out.println(count);
    }

    public static int asc(List<Integer> list){
        int count = 1;
        for (int i = 1; i < list.size()-1; i++) {
            if(list.get(i-1) < list.get(i+1))
                count++;
        }
        return count;
    }
    public static int desc(List<Integer> list){
        int count = 1;
        for (int i = 1; i < list.size()-1; i++) {
            if(list.get(i-1) > list.get(i+1))
                count++;
        }
        return count;
    }
}
