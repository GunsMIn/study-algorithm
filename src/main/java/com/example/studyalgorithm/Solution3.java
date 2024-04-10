package com.example.studyalgorithm;

import java.util.Arrays;
import java.util.Collections;

public class Solution3 {

    //정수 내림차순으로 배치하기
    //문자열만들기
    //반복문 돌면서
    public long solution(long n) {
        long answer = 0;
        String value = String.valueOf(n);
        String[] arrayValue = value.split("");
        Arrays.sort(arrayValue, Collections.reverseOrder()); // 내림차순
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayValue.length; i++) {
            stringBuilder.append(arrayValue[i]);
        }
        answer = Long.parseLong(stringBuilder.toString());

        return answer;
    }

    public long solution2(long n) {
        String[] arr = String.valueOf(n).split("");
        Arrays.sort(arr); // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]); // 문자 하나씩 합치기
        }

        return Long.parseLong(sb.reverse().toString());

    }
}
