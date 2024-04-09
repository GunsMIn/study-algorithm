package com.example.studyalgorithm;

import java.util.Locale;
import java.util.Stack;

public class Solution2 {


    // 자연수 뒤집어 배열로 만들기
    // soultion 1
    public int[] solution(long n) {

        String s = String.valueOf(n);

        int[] answer = new int[s.length()];

        int cnt = 0;

        while (n > 0) {
            answer[cnt] = (int) (n % 10);
            n /= 10;
            cnt++;
        }
        return answer;
    }

    //solution 2
    public int[] solution2(long n) {

        //Stringbuilder 에는 문자열만 들어갈 수 있다.
        String reversedString = new StringBuilder(String.valueOf(n)).reverse().toString();

        int[] answer = new int[reversedString.length()];

        for (int i = 0; i < reversedString.length(); i++) {
            answer[i] = Character.getNumericValue(reversedString.charAt(i));
        }
        return answer;
    }
}
