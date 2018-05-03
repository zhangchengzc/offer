package com.offer.chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcheng on 2018/4/19.
 */
public class Number20 {

    @Test
    public void test(){
        int[][] array = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = getMatrixClockwise(array);
        System.out.println(list);
    }

    /**
     * 由外而内打印
     * @param matrix
     * @return
     */

    public List<Integer> getMatrixClockwise(int[][] matrix){
        int rowLow = 0,rowHigh = matrix.length-1;
        int colLow = 0,colHigh = matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        while(rowLow <= rowHigh && colLow <= colHigh){
            for( int i = colLow ; i <= colHigh; ++i)
                list.add(matrix[rowLow][i]);
            rowLow++;
            for(int i = rowLow ; i<= rowHigh ; ++i)
                list.add(matrix[i][colHigh]);
            colHigh--;
            for(int i = colHigh ; i >= colLow ; --i)
                list.add(matrix[rowHigh][i]);
            rowHigh--;
            for(int i = rowHigh ; i >= rowLow ; --i)
                list.add(matrix[i][colLow]);
            colLow++;

        }
        return list;
    }
}
