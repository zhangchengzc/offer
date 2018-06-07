package com.offer.chapter8;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by zhangcheng on 2018/6/5.
 */
public class Number60 {

    @Test
    public void test(){
        int[] preOrder = {1};
        int[] inOrder = {1};
        BinaryTreeNode root = new BuildBinaryTree().buildPreIn(preOrder,inOrder,0,preOrder.length-1,0,inOrder.length-1);
        printLevelOrder(root);
    }

    /**
     * 结合层次遍历，使用两个变量分别表示当前层结点个数和下一层结点个数
     * @param root
     */
    public void printLevelOrder(BinaryTreeNode root){
        if(root == null)
            return;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int countCurLevel = 1;
        int countNextLevel = 0;
        while(!queue.isEmpty()){
            if(queue.peek().left != null){
                queue.add(queue.peek().left);
                countNextLevel++;
            }
            if(queue.peek().right != null){
                queue.add(queue.peek().right);
                countNextLevel++;
            }
            System.out.print(queue.poll().value+" ");
            countCurLevel--;
            if(countCurLevel == 0)
            {
                System.out.println();
                countCurLevel = countNextLevel;
                countNextLevel = 0;
            }

        }
    }
}
