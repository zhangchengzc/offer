package com.offer.bishi.meituan;

/**
 * Created by zhangcheng on 2018/9/4.
 */
public class RotateArray {

    public static void main(String[] args){
        int[] array = new int[]{10,17,20,1};
        minNumberInRotateArray(array);
    }

    /**
     * @param arr
     */
    public static void minNumberInRotateArray(int[] arr){
        int index = minNumberInRotateArray(arr,0,arr.length-1);
        System.out.println("position:"+index+"  value:"+arr[index]);
    }

    /**
     * 二分查找查找数组中最小元素
     * @param array
     * @param left 指向数组中递增部分
     * @param right 指向数组中递减部分
     * @return 最小值位置pos
     */
    public static int minNumberInRotateArray(int[] array,int left,int right)
    {
        if(array[left] < array[right])
            return left;
        if(left+1<right){
            int mid = (left+right)/2;
            if(array[mid] >= array[left])
                return minNumberInRotateArray(array,mid,right);
            else
                return minNumberInRotateArray(array,left,mid);
        }else
            return right;
    }
}
