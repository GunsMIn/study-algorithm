package com.example.studyalgorithm;

public class Solution5 {
    //정수 제곱근 판별 (https://school.programmers.co.kr/learn/courses/30/lessons/12934)
    public long solution(long n) {
        long answer = 0;
        long sqrt = (long) Math.sqrt(n);// n의 제곱근을 구하고, long 타입으로 형변환

        if (sqrt * sqrt == n) {
            // x의 제곱이 n과 같다면, x는 n의 제곱근이므로 (x+1)의 제곱을 반환
            return (sqrt + 1) * (sqrt + 1);
        } else {
            // x의 제곱이 n과 다르면, n은 어떤 수의 제곱이 아님
            return -1;
        }
    }
}
