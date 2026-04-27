package com.example.studyalgorithm;

import java.util.Arrays;

public class Solution9 {
    public boolean solution(String[] phone_book) {
        // 전화번호부를 사전순으로 정렬
        Arrays.sort(phone_book);
//
        // 인접한 번호들끼리 접두사인지 확인
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 앞 번호가 뒤 번호의 접두사인지 확인
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;  // 접두사가 존재하면 false 반환
            }
        }

        return true;  // 접두사가 없으면 true 반환
    }
}
