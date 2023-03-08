package com.finn.start;

import java.util.HashMap;
import java.util.Map;

public class RomaNumber {

    public static void main(String[] args) {
        System.out.println(getRomaNumber("IVIV"));
    }


    public static Integer getRomaNumber(String s) {

        Map<Character, Integer> romaNum = new HashMap<>();
        romaNum.put('a', 4);
        romaNum.put('b', 9);
        romaNum.put('c', 40);
        romaNum.put('d', 90);
        romaNum.put('e', 400);
        romaNum.put('f', 900);
        romaNum.put('I', 1);
        romaNum.put('V', 5);
        romaNum.put('X', 10);
        romaNum.put('L', 50);
        romaNum.put('C', 100);
        romaNum.put('D', 500);
        romaNum.put('M', 1000);

        s = s.replace("IV", "a").replace("IX", "b")
                .replace("XL", "c").replace("XC", "d")
                .replace("CD", "e").replace("CM", "f");

        Integer sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += romaNum.get(s.charAt(i));
        }
        return sum;
    }
}

