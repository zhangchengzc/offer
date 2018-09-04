package com.offer.chapter2;


/**
 * Created by zhangcheng on 2018/4/8.
 */
public class RotateArray {

    public static void main(String[] args){
        int[] array = new int[]{3,4,1,2};
        System.out.println(findMin(array,0,6));
    }

    public static int findMin(int[] array,int left,int right)
    {
        if(array[left]<array[right])
            return array[left];
        if(left+1<right){
            int mid = (left+right)/2;
            if(array[left] == array[right] && array[left] == array[mid])
                return minInOrder(array,left,right);
            if(array[mid] >= array[left])
                return findMin(array,mid,right);
            else
                return findMin(array,left,mid);
        }else
            return array[right];
    }

    public static int minInOrder(int[] array,int left,int right)
    {
        int min = array[left];
        for(int i = left+1;i<right;++i)
        {
            if(array[i] < min) {
                min = array[i];
                break;
            }
        }
        return min;
    }
}
