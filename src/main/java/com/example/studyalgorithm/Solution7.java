package com.example.studyalgorithm;

public class Solution7 {

    //핸드폰 번호 가리기 (https://school.programmers.co.kr/learn/courses/30/lessons/12948)
    public String solution(String phone_number) {

        int length = phone_number.length();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length - 4; i++) {
            stringBuilder.append("*");
        }

        stringBuilder.append(phone_number.substring(length - 4));
        return stringBuilder.toString();
    }

}
