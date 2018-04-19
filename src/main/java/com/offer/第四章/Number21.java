package com.offer.第四章;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by zhangcheng on 2018/4/19.
 */
public class Number21 {

    @Test
    public void test() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.pop());
        System.out.println(stack.getMin());
    }
}

/**
 * 在O(l)时间内push、pop、getMin()的栈
 */
class Stack<T extends Comparable>{
    ArrayDeque<T> stack;
    ArrayDeque<T> minStack;
    public Stack(){
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    /**
     * 入栈
     * @param data
     * @return
     */
    public boolean push(T data){
        stack.push(data);
        if(minStack.isEmpty())
            minStack.push(data);
        else if(data.compareTo(minStack.peek()) < 0)
            minStack.push(data);
        else
            minStack.push(minStack.peek());
        return true;
    }

    /**
     * 出栈
     * @return
     * @throws Exception
     */
    public T pop() throws Exception{
        if(stack.isEmpty()){
            throw new Exception("栈空不能pop");
        }
        minStack.pop();
        return stack.pop();
    }

    /**
     * 得到栈中最小的元素
     * @return
     */
    public T getMin(){
        if(stack.isEmpty())
            return null;
        return minStack.peek();
    }
}
