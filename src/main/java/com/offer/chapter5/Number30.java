package com.offer.chapter5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhangcheng on 2018/5/11.
 */
public class Number30 {

    @Test
    public void test(){
        int[] num = {4,5,1,6,2,7,3,8};
        try {
            System.out.println(findLessKUsingHeap(num, 4));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 使用一个大小为k的大根堆来存储较小的k个数
     * @param num
     * @param k
     * @return
     * @throws Exception
     */
    public PriorityQueue<Integer> findLessKUsingHeap(int[] num ,int k) throws  Exception
    {
        if(num == null)
            throw new Exception("Array is null");
        if(num.length < k)
            throw new Exception("Array.length is less than k");
        PriorityQueue<Integer> heap = new PriorityQueue<>(k,(o1,o2)->o2.compareTo(o1));
        int index = 0;
        for(;index < k; ++index)
            heap.add(num[index]);
        for(;index < num.length;++index)
        {
            if(num[index] >= heap.peek())
                continue;
            else {
                heap.poll();
                heap.add(num[index]);
            }
        }
        return heap;
    }
    /**
     * 使用partition方法查找k个小的数
     * @param num
     * @param k
     * @return
     * @throws Exception
     */
    public List<Integer> findLessK(int[] num,int k) throws Exception{
        if(num == null)
            throw new Exception("Array is null");
        if(num.length < k)
            throw new Exception("Array.length is less than k");
        int[] numClone = num.clone();
        Number29 pt = new Number29();
        int index = pt.partition(numClone,0,numClone.length-1);
        while(index != k-1)
        {
            if(index > k-1)
                index = pt.partition(numClone,0,index-1);
            else
                index = pt.partition(numClone,index+1,numClone.length-1);
        }
        List<Integer> list = new ArrayList<>(k);
        for(int i = 0;i < k;){
            list.add(numClone[i++]);
        }
        return list;
    }
}
