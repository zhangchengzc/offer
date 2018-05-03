package com.offer.chapter4;

import com.offer.chapter2.二叉树.BinaryTreeNode;
import com.offer.chapter2.二叉树.BuildBinaryTree;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by zhangcheng on 2018/4/19.
 */
public class Number19 {

    /**
     * @see com.offer.chapter2.二叉树.BuildBinaryTree#buildPreIn(int[], int[], int, int, int, int)
     */
    @Test
    public void test(){
        int[] preorder  = new int[]{1,2,5,3,6,7};
        int[] inorder = new int[]{2,5,1,6,3,7};
        BuildBinaryTree build = new BuildBinaryTree();
        BinaryTreeNode pHead1 = build.buildPreIn(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        BinaryTreeNode p = getTreeMirrorNoRecursion(pHead1);
        System.out.println();
    }

    /**
     * 使用递归方法返回二叉树root的镜像树
     * @param root
     * @return
     */
    public BinaryTreeNode getTreeMirror(BinaryTreeNode root){
        if(root == null)
            return null;
        BinaryTreeNode pRoot = new BinaryTreeNode(root.value);//注意这里不能直接指向root(会改变原来树的结构)，而是构建一个新的对象
        pRoot.left = getTreeMirror(root.right);
        pRoot.right = getTreeMirror(root.left);
        return pRoot;
    }

    /**
     * 使用层次遍历方法返回二叉树root的镜像树
     * @param root
     * @return
     */
    public BinaryTreeNode getTreeMirrorNoRecursion(BinaryTreeNode root){
        if(root == null)
            return null;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        BinaryTreeNode cur;
        while(!queue.isEmpty()){
            cur = queue.poll();
            BinaryTreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = temp;
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right != null)
                queue.add(cur.right);
        }
        return root;
    }
}
