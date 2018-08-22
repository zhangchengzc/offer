package com.offer.bishi.toutiao;

import java.util.*;

/**
 * Created by zhangcheng on 2018/8/12.
 */
public class Number2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();
        Map<Integer,Integer> error= new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] str = in.nextLine().trim().split(";");
            for (int j = 0; j < str.length; j++) {
                int index = str[j].indexOf(',');
                error.put(Integer.valueOf(str[j].substring(0,index)),Integer.valueOf(str[j].substring(index+1)));
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:error.entrySet()) {
            list.add(entry.getKey());
        }
        TreeMap<Integer,Integer> merge = new TreeMap<>();
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            int j = i+1;
            int max = error.get(list.get(i));
            for (; j < list.size(); j++) {
                if(list.get(j) > error.get(list.get(j-1))+1)
                    break;
                else
                    max = error.get(list.get(j)) > max ? error.get(list.get(j)) : max;
            }

            merge.put(list.get(i),max);
            i = j-1;

        }
        List<String> list1 = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry:merge.entrySet()) {
            list1.add(String.valueOf(entry.getKey()));
            list1.add(",");
            list1.add(String.valueOf(entry.getValue()));
            list1.add(";");
        }
        for (int i = 0; i < list1.size()-1; i++) {
            System.out.print(list1.get(i));
        }
    }
}
