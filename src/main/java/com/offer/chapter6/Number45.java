package com.offer.chapter6;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangcheng on 2018/5/29.
 */
public class Number45 {

    @Test
    public void test(){
        System.out.println(getLeftNum(5,3));
        System.out.println(getLastNum(5,3));
    }

    /**
     * 使用一个链表来模仿这个圆圈。
     * @param n
     * @param m
     * @return
     */
    public int getLeftNum(int n,int m){
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i < n; ++i)
            list.add(i);
        int index = 0;
        int count = 1;
        while(list.size() > 1){//LinkedList中使用一个私有的int变量size保存list的长度，每次增删时都改变这个变量的大小
            if(count == m){
                if(index == list.size()-1)
                {
                    list.remove(index);
                    index = 0;
                    count = 1;
                }else{
                    list.remove(index);
                    count = 1;
                }
            }else if(index == list.size() - 1)
            {
                index = 0;
                count++;
            }else
            {
                index++;
                count++;
            }
        }
        return list.get(0);
    }

    /**
     * 利用数学公式推导得到
     * @param n
     * @param m
     * @return
     */
    public int getLastNum(int n,int m){
        int last = 0;
        for(int i=2;i<=n;++i){
            last = (last+m)%i;
        }
        return last;
    }
}
