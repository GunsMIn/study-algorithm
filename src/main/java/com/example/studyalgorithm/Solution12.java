package com.example.studyalgorithm;

import java.util.Arrays;

public class Solution12 {

    public String solution(int[] numbers) {

        String[] temp = new String[numbers.length];

        for(int i =0 ; i < temp.length; i++){
            temp[i] = String.valueOf(numbers[i]);
        }

        // temp 배열에 "6" "10" "2" 이런식으로 담겨있을거다
        //아래의 코드에서 610 10
        Arrays.sort(temp,(a,b) -> (b+a).compareTo(a+b));

        if(temp[0].equals("0")) return "0";

        StringBuilder stringBuilder = new StringBuilder();

        for(String text :temp){
            stringBuilder.append(text);
        }


        return stringBuilder.toString();

    }
}
