package com.example.studyalgorithm;

public class Solution6 {


   /**
    * 우선 각자리를 추출해야함 그렇기 위해서는 x 를 string으로 변환
    * */
   public boolean solution(int x) {

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
