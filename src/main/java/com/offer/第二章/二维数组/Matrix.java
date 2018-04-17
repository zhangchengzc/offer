package com.offer.第二章.二维数组;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/7.
 */
public class Matrix {
    @Test
    public void main(){
        int[][] array = new int[][]{{1,3,4,5},{8,9,10,11}};
        System.out.println(find(array,0,array[0].length,3));
    }

    public boolean find(int[][] matrix,int rows,int cols,int num)
    {
        if(matrix!= null && rows < matrix.length && cols > 0)
        {
            int comp = matrix[rows][cols-1];
            if(comp == num)
                return true;
            else if(comp > num)
                return find(matrix,rows,cols-1,num);
            else
                return find(matrix,rows+1,cols,num);
        }else
            return false;
    }
}
