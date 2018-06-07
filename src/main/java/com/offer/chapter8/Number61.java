package com.offer.chapter8;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by zhangcheng on 2018/6/7.
 */
public class Number61 {

    @Test
    public void test(){
        int[] preOrder = {1,2,4,8,9,5,10,11,3,6,12,13};
        int[] inOrder = {8,4,9,2,10,5,11,1,12,6,13,3};
        BinaryTreeNode root = new BuildBinaryTree().buildPreIn(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
        printLevelTree(root);
    }


    /**
     * 在偶数行通过创建一个栈来保存出队的元素
     * @param root
     */
    public void printLevelTree(BinaryTreeNode root){
        if(root == null)
            return;
        boolean flag = true;
        int countCur = 1;
        int countNext = 0;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        ArrayDeque<BinaryTreeNode> stack = new ArrayDeque<>();
        while(!queue.isEmpty()){
            if(queue.peek().left != null){
                queue.add(queue.peek().left);
                countNext++;
            }
            if(queue.peek().right != null){
                queue.add(queue.peek().right);
                countNext++;
            }
            if(flag){
                System.out.print(queue.poll().value + " ");
                countCur--;
                if(countCur == 0){
                    System.out.println();
                    countCur = countNext;
                    countNext = 0;
                    flag = false;
                }
            }else {
                stack.push(queue.poll());
                countCur--;
                if(countCur == 0)
                {
                    countCur = countNext;
                    countNext = 0;
                    while(!stack.isEmpty())
                        System.out.print(stack.pop().value+" ");
                    System.out.println();
                    flag = true;
                }
            }
        }
    }
}
