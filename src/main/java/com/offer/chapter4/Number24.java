package com.offer.chapter4;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/20.
 */
public class Number24 {

    @Test
    public void test(){
        int[] postOrder = {7,4,6,5};
        System.out.println(isPostOrder(postOrder,0,postOrder.length-1));
    }

    /**
     *判断输入数组是否是某个二叉搜索树的后序序列
     * @param postOrder 输入数组
     * @param left 数组的最小索引
     * @param right 数组的最大索引
     * @return
     */
    public boolean isPostOrder(int[] postOrder,int left,int right){
        if(postOrder == null || postOrder.length == 0)
            return false;
        if(left < right){
            int index = 0;
            for(; postOrder[index] < postOrder[right] ; ++index);
            for(int i = index; i< right ; ++i){
                if(postOrder[i] < postOrder[right])
                    return false;
            }
            return isPostOrder(postOrder,left,index-1) && isPostOrder(postOrder,index,right-1);
        }
        return true;
    }

}
