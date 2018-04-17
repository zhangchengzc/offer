package com.offer.第二章.字符串;

import org.junit.Test;

/**
 * Created by zhangcheng on 2018/4/7.
 */
public class ReplaceBlank {

    @Test
    public void main(){
        System.out.println(replaceBlank("we are chinese","%20"));
    }


    public String replaceBlank(String input,String replace)
    {
        return input.replaceAll(" ",replace);
    }
}
