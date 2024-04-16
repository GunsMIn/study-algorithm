package com.example.studyalgorithm;

import java.util.Arrays;

public class Solution8 {

    public int solution(int[] people, int limit) {
        int boatsCount = 0;
        //우선 오름차순 정렬 50,50,70,80
        //                0   1  2  3
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;

        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                // 두 사람을 함께 보내고, start 인덱스를 증가시켜 다음 가장 가벼운 사람으로 이동
                start++;
            }
            end--; // end 인덱스를 감소시켜 다음 가장 무거운 사람을 처리
            boatsCount++;
        }
        return boatsCount;
    }
}
