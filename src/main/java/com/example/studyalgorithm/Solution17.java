package com.example.studyalgorithm;

import java.util.*;

public class Solution17 {

    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> daysQueue = new ArrayDeque<>();


        for(int i =0; i<progresses.length; i++){
            int remainingProgress = 100 - progresses[i];

            int remainingDays = (int)Math.ceil((double)(remainingProgress / speeds[i]));

            daysQueue.offer(remainingDays);
        }


        List<Integer> result = new ArrayList<>();


        while(!daysQueue.isEmpty()){
            int deploymentDay = daysQueue.poll();

            int count =1;

            while(!daysQueue.isEmpty() && daysQueue.peek() <= deploymentDay){
                daysQueue.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
































    // [93, 30, 55]	[1, 30, 5]	[2, 1]
    public int[] solution2(int[] progresses, int[] speeds) {

        // 배포일자
        Queue<Integer> progressDay =new ArrayDeque<>();


        for(int i=0; i<progresses.length; i++){

            // 남은 프로세스
            int remainProgress = 100 - progresses[i];
            //잔여일자 넣기 [7,3,10]
            progressDay.offer((int) Math.ceil((double)remainProgress / speeds[i]));
        }


        List<Integer> answer = new ArrayList<>();
        while(!progressDay.isEmpty()){

            int count = 1;

            int previousProgressDay = progressDay.poll();

            while (!progressDay.isEmpty() && progressDay.peek() <= previousProgressDay) {
                progressDay.poll();
                count++;
            }

            answer.add(count);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }




}
