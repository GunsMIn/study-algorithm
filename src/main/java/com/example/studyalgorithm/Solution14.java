package com.example.studyalgorithm;

import java.util.Arrays;

public class Solution14 {

    //https://school.programmers.co.kr/learn/courses/30/lessons/42748
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int index=0; index < commands.length; index++){
            int i = commands[index][0];
            int j = commands[index][1];
            int k = commands[index][2];

            int[] slicedArray = Arrays.copyOfRange(array, i - 1, j);

            Arrays.sort(slicedArray);

            answer[index] = slicedArray[k-1];
        }

        return answer;
    }
}
