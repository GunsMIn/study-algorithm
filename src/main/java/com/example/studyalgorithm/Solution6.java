package com.example.studyalgorithm;

public class Solution6 {

    //하샤드 수
    public boolean solution(int x) {
        int sum = 0;
        int original = x;  // 원래 숫자를 저장해두고

        while (x > 0) {
            sum += x % 10;  // 각 자릿수를 더하기
            x /= 10;
        }

        return original % sum == 0;  // 원래 숫자를 자릿수의 합으로 나누어 떨어지는지 검사
    }

    /**
    * 우선 각자리를 추출해야함 그렇기 위해서는 x 를 string으로 변환
    * */
   public boolean solution2(int x) {

       int sum = 0;
       String s = String.valueOf(x);

       for (int i = 0; i < s.length(); i++) {
           sum += Integer.parseInt(String.valueOf(s.charAt(i)));
       }

       if (x % sum == 0) {
           return true;
       } else {
           return false;
       }

   }
}
