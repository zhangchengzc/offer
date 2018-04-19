package com.offer.第四章;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * Created by zhangcheng on 2018/4/19.
 */
public class Number22 {


    @Test
    public void test(){
        int[] pushOrder = {1,2,3,4,5};
        int[] popOrder = {4,3,5,1,2};
        System.out.println(isPopOrder(pushOrder,popOrder));
    }

    /**
     * 判断出栈队列是否是入栈队列出队列的情况之一
     * @param pushOrder
     * @param popOrder
     * @return
     */
    public boolean isPopOrder(int[] pushOrder,int[] popOrder){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for(; pushOrder[index] != popOrder[0]; ++index)
            stack.push(pushOrder[index]);
        stack.push(pushOrder[index]);
        for(int i = 0 ; i < popOrder.length ; ++i){
            if(stack.peek() == popOrder[i])//若栈顶元素等于出栈序列中元素，则直接出栈
                stack.pop();
            else {
                for(index++; index < pushOrder.length && pushOrder[index]!=popOrder[i];++index)//负责继续遍历入栈数组，知道找到出栈元素对应的入栈元素
                    stack.push(pushOrder[index]);
                if(index == pushOrder.length)//没找到则返回false
                    return false;
            }
        }
        return true;
    }
}
