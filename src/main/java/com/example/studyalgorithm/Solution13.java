package com.example.studyalgorithm;

import java.util.HashSet;

public class Solution13 {

    public int solution(int[] nums) {
        int max  = nums.length / 2 ;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length;i++) {
            set.add(i);
        }

        if (set.size() < max) {
            return set.size();
        } else {
            return max;
        }

    }
}
