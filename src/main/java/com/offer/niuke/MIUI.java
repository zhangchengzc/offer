package com.offer.niuke;

import java.util.Scanner;

/**
 * Created by zhangcheng on 2018/9/3.
 */
public class MIUI {
    private static String[] number = {"EIGHT", "NINE","ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int T = in.nextInt();
            String[] strs = new String[T];
            for (int i = 0; i < T; i++) {
                strs[i] = in.next();
            }
            for (int i = 0; i < strs.length; i++) {
                System.out.println(getOrigin(strs[i]));
            }
        }
    }

    public static String getOrigin(String str){
        int numG = 0,numI = 0,numF = 0,numU = 0, numX = 0,numZ = 0,numO = 0,numW = 0,numR = 0,numS = 0;
        for (char c:str.toCharArray()) {
            switch (c){
                case 'G' : numG++;break;
                case 'I' : numI++;break;
                case 'F' : numF++;break;
                case 'U' : numU++;break;
                case 'X' : numX++;break;
                case 'Z' : numZ++;break;
                case 'O' : numO++;break;
                case 'W' : numW++;break;
                case 'R' : numR++;break;
                case 'S' : numS++;break;
            }
        }
        StringBuilder sl = new StringBuilder();
        for (int i = 0; i < numG; i++) sl.append(0);
        for (int i = 0; i < numI-numG-numF+numU-numX; i++) {
            sl.append(1);
        }
        for (int i = 0; i < numZ; i++) {
            sl.append(2);
        }
        for (int i = 0; i < numO-numW-numU-numZ; i++) {
            sl.append(3);
        }
        for (int i = 0; i < numW; i++) {
            sl.append(4);
        }
        for (int i = 0; i < numR-numZ-numU; i++) {
            sl.append(5);
        }
        for (int i = 0; i < numU; i++) {
            sl.append(6);
        }
        for (int i = 0; i < numF - numU; i++) {
            sl.append(7);
        }
        for (int i = 0; i < numX; i++) {
            sl.append(8);
        }
        for (int i = 0; i < numS-numX; i++) {
            sl.append(9);
        }
        return sl.toString();

    }
}
