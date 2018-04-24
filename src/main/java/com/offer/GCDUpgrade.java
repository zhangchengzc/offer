package com.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/4/20.
 */
public class GCDUpgrade {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            int p = in.nextInt();
            List<Integer> list = new ArrayList<>();
            list.add(p);
            int cur = p;
            for (int i = 1; i < N; ++i) {
                cur = (cur + 153) % p;
                list.add(cur);
            }
            long sum = 0;
            if(n < m){
                for(int i = 0; i < n ; ++i)
                    sum += list.get(i);
                for(int i = 0;i < n ; ++i)
                    for(int j = i+1 ;j < n; ++j)
                        sum += 2*list.get(gcd(i+1,j+1)-1);
                for(int i=0;i<n; ++i)
                    sum += list.get(gcd(i+1,m)-1);
            }else if(n == m){
                for(int i = 0; i < n ; ++i)
                    sum += list.get(i);
                for(int i = 0;i < n ; ++i)
                    for(int j = i+1 ;j < n; ++j)
                        sum += 2*list.get(gcd(i+1,j+1)-1);
            }else{
                for(int i = 0; i < m ; ++i)
                    sum += list.get(i);
                for(int i = 0;i < m ; ++i)
                    for(int j = i+1 ;j < m; ++j)
                        sum += 2*list.get(gcd(i+1,j+1)-1);
                for(int i=0;i<m; ++i)
                    sum += list.get(gcd(n,i+1)-1);

            }
            System.out.println(sum);
        }
    }

    public static int gcd(int m, int n){
        while(m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }
}
