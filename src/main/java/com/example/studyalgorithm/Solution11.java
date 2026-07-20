package com.example.studyalgorithm;

import java.util.Arrays;

public class Solution11 {

    public int[] solution(int[] array, int[][] commands) {

        // 우선 리턴할 포멧을 생각
        int[] answer = new int[commands.length];

        // 이차배열에서 우선 반복문을 돌면서 하나씩 돌리겠다는 마인드.
        for(int n =0; n < commands.length ; n++){
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];


            int[] temp = new int[j-i+1];

            for(int m =0; m <temp.length ; m++){
                temp[m] = array[i-1+m];
            }

            Arrays.sort(temp);

            answer[n] = temp[k-1];

        }

        return answer;
    }
}
