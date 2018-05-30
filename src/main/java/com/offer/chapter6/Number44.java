package com.offer.chapter6;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangcheng on 2018/5/29.
 */
public class Number44 {

    @Test
    public void test(){
        int[] cards = {0,0,1,11,13};
        System.out.println(isIncrement(cards));
    }

    /**
     * @param cards
     * @return
     */
    public boolean isIncrement(int[] cards){
        Arrays.sort(cards);
        int count0 = 0;
        for (int i = 1; i < cards.length; i++) {
            if(cards[i-1] == 0)//计算0的个数
            {
                count0++;
                continue;
            }
            if(cards[i] == cards[i-1])
                return false;
        }
        int countBlank = 0;
        for (int i = count0+1; i < cards.length; i++) {//计算不连续的差值
            countBlank += cards[i] - cards[i-1]-1;
        }
        if(countBlank <= count0)
            return true;
        else if(cards[count0] == 1 && cards[count0+1] >= 10)//判断是否存在10 j Q K A情况
            return true;
        else
            return false;

    }
}
