package com.offer.chapter8;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/6/1.
 */
public class Number51 {

    @Test
    public void test(){
        int[] array = {2,1,0,3};
        System.out.println(getRepeatedNum(array));
    }

    /**
     *
     * @param array
     * @return
     */
    public int getRepeatedNum(int[] array){
        if(array == null || array.length == 0)
            return -1;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == i)
                continue;
            else if(array[array[i]] == array[i])
                return array[i];
            else{
                temp = array[i];
                array[i] = array[array[i]];
                array[temp] = temp;
                i--;
            }
        }
        return -1;
    }
}
