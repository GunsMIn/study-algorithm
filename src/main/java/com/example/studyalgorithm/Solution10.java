package com.example.studyalgorithm;

import java.util.HashMap;
import java.util.Map;

public class Solution10 {

    public int solution(String[][] clothes) {
        int answer =1;
        Map<String,Integer> map = new HashMap<>();


        for(String[] cloth :clothes){
            String type = cloth[1];
            map.put(type,map.getOrDefault(type,0)+1);
        }


        for(int count :map.values()){
            answer *= count + 1 ;
        }

        return answer -1;
    }
}
