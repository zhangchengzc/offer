package com.offer.chapter8;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by zhangcheng on 2018/7/12.
 */
public class Number65 {

    @Test
    public void test(){
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(num,3));
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        if(num == null || num.length == 0)
            return new ArrayList<>();
        if(num.length < size)
            return new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> queueMax = new ArrayDeque<>();
        queue.add(num[0]);
        queueMax.add(num[0]);
        for(int i = 1;i < size; ++i)
        {
            queue.add(num[i]);
            if(num[i] >= queueMax.getLast())
                queueMax.add(num[i]);
            else
                queueMax.add(queueMax.getLast());
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(queueMax.getLast());
        for(int i = size;i < num.length; ++i){
            queue.poll();
            queue.add(num[i]);
            if(num[i] >= queueMax.getLast()){
                queueMax.add(num[i]);
                list.add(num[i]);
                queueMax.poll();
            }else {
                queueMax.add(queue.getLast());
                queueMax.poll();
                list.add(queue.getLast());
            }
        }
        return list;
    }
}
