package com.offer.第四章;

import com.offer.第二章.二叉树.BinaryTreeNode;
import com.offer.第二章.二叉树.BuildBinaryTree;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhangcheng on 2018/4/20.
 */
public class Number23 {


    @Test
    public void test(){
        int[] preorder  = new int[]{1,2,4,5,3,6,7};
        int[] inorder = new int[]{4,2,5,1,6,3,7};
        BuildBinaryTree build = new BuildBinaryTree();
        BinaryTreeNode pHead1 = build.buildPreIn(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        System.out.println(levelOrder(pHead1));

    }
    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<Integer> levelOrder(BinaryTreeNode root){
        if(root == null)
            return null;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        BinaryTreeNode cur;
        queue.add(root);
        while(!queue.isEmpty()){
            cur = queue.poll();
            list.add(cur.value);
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
        return list;
    }
}
