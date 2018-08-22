package com.offer.bishi.cvte;

import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcheng on 2018/7/20.
 */
public class Number3 {

    @Test
    public void test(){
        System.out.println(generator());
    }

    List<String> list = new ArrayList<>();

    /**
     * A-Z
     * @return
     */
    public String generator(){
        char[] digit = new char[11];
        for(int i = 0;i < 11; ++ i){
            digit[0] = (char)('0' + i);
            fullArrangement(digit,0);
        }
        String str = list.get((int)getTotal());
        StringBuilder sl = new StringBuilder();
        for(int i = 0;i<str.length();++i){
            if(str.charAt(i) >= '0' && str.charAt(i)<='9')
                sl.append(str.charAt(i));
            else if(str.charAt(i) >= 10 && str.charAt(i) <= 35)
                sl.append(str.charAt(i)+55);
            else
                sl.append(str.charAt(i) + 61);
        }
        return sl.toString();

    }
    public long getTotal(){
        return 1;
    }

    /**
     * 使用全排列的方法打印
     * @param n
     */
    public void print1ToN2(int n){
        if(n <= 0)
            return;
        char[] digit = new char[n];
        for(int i = 0;i < 10; ++i)
        {
            digit[0] = (char)('0'+i);
            fullArrangement(digit,0);
        }
    }

    public void fullArrangement(char[] digit,int index){
        if(index == digit.length-1)
        {
            list.add(String.valueOf(digit));
            return;
        }
        for(int i=0;i<10;++i)
        {
            digit[index+1] = (char)('0'+i);
            fullArrangement(digit,index+1);
        }
    }
}
