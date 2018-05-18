package com.offer.chapter5;

import org.junit.Test;


/**
 * Created by zhangcheng on 2018/5/17.
 */
public class Number36 {

    @Test
    public void test(){
        System.out.println(getReversePair(new int[]{10,7,5,8,4}));
    }

    /**
     * 为归并排序作基础
     * @param num
     * @return
     */
    public int getReversePair(int[] num){
        if(num == null || num.length == 0)
            return 0;
        int[] numCopy = num.clone();
        int count = getCountOfReversePair(numCopy,new int[numCopy.length],0,numCopy.length-1);
        return count;
    }

    /**
     * 归并排序
     * @param num
     * @param temp
     * @param left
     * @param right
     * @return
     */
    private int getCountOfReversePair(int[] num,int[] temp,int left,int right){
        if(left == right){
            temp[left] = num[right];
            return 0;
        }
        int mid = (right + left)/2;
        int leftCount = getCountOfReversePair(num,temp,left,mid);
        int rightCount = getCountOfReversePair(num,temp,mid+1,right);
        int count = getMergeCount(num,temp,left,mid,right);
        return leftCount + count + rightCount;
    }

    /**
     * 归并排序中合并的一部分
     * @param num
     * @param temp
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int getMergeCount(int[] num,int[] temp,int left,int mid,int right){
        int leftEnd = mid;
        int rightBegin = mid+1;
        int rightPos = right;
        int count = 0;
        int length = right-left+1;
        while(left <= leftEnd && rightBegin <= right){
            if(num[leftEnd] >= num[right]){
                count += right-rightBegin+1;
                temp[rightPos--] = num[leftEnd--];
            }else
                temp[rightPos--] = num[right--];
        }
        while(left <= leftEnd)
            temp[rightPos--] = num[leftEnd--];
        while(rightBegin <= right)
            temp[rightPos--] = num[right--];
        for (int i = 0; i < length ; i++) {
            num[left] = temp[left];
            left++;
        }
        return count;
    }
}
