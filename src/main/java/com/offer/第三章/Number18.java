package com.offer.第三章;

import com.offer.第二章.二叉树.BinaryTreeNode;
import com.offer.第二章.二叉树.BuildBinaryTree;
import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/17.
 */
public class Number18 {

    /**
     * @see com.offer.第二章.二叉树.BuildBinaryTree#buildPreIn(int[], int[], int, int, int, int)
     */
    @Test
    public void test(){
        int[] preorder  = new int[]{1,2,4,7,3,5,6,8};
        int[] inorder = new int[]{4,7,2,1,5,3,8,6};
        BuildBinaryTree build = new BuildBinaryTree();
        BinaryTreeNode pHead1 = build.buildPreIn(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        BinaryTreeNode pHead2 = new BinaryTreeNode(3);
        pHead2.left = new BinaryTreeNode(5);
        pHead2.right = new BinaryTreeNode(6);
        System.out.println(isSubTree(pHead1,pHead2));
        System.out.println(contain(pHead1,4));//附加二叉树查找
    }

    /**
     * 在pHead1中查找和pHead2相等的结点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public boolean isSubTree(BinaryTreeNode pHead1,BinaryTreeNode pHead2){
        boolean result = false;
        if(pHead1 != null && pHead2 != null)
        {
            if(pHead1.value == pHead2.value)
                result = judge(pHead1,pHead2);
            if(!result)
                result = isSubTree(pHead1.left,pHead2);
            if(!result)
                result = isSubTree(pHead1.right,pHead2);
        }
        return result;
    }

    /**
     * 判断pHead2是否属于pHead1
     * @param pHead1
     * @param pHead2
     * @return
     */
    private boolean judge(BinaryTreeNode pHead1,BinaryTreeNode pHead2){
        if(pHead2 == null)
            return true;
        if(pHead1 == null)
            return false;
        if(pHead1.value != pHead2.value)
            return false;
        return judge(pHead1.left,pHead2.left) && judge(pHead1.right,pHead2.right);//递归调用
    }

    /**
     * 判断树中是否包含某个值
     * @param pHead
     * @param value
     * @return
     */
    public boolean contain(BinaryTreeNode pHead,int value)
    {
        if(pHead == null)
            return false;
        if(pHead.value == value)
            return true;
        return contain(pHead.left,value) || contain(pHead.right,value);
    }
}
